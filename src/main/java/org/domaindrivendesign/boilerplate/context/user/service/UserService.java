package org.domaindrivendesign.boilerplate.context.user.service;

import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.domaindrivendesign.boilerplate.context.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final String TMP_PASSWORD = "123456";
    @Autowired
    private UserRepository userRepository;
    public Page<User> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User addUser(User user) {
        user.setPassword(TMP_PASSWORD);
        return userRepository.save(user);
    }
}
