package org.domaindrivendesign.boilerplate.context.user.service;

import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.domaindrivendesign.boilerplate.context.user.model.UserRole;
import org.domaindrivendesign.boilerplate.context.user.repository.UserRepository;
import org.domaindrivendesign.boilerplate.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.domaindrivendesign.boilerplate.core.exception.ErrorCode.USER_NOT_FOUND;

@Service
public class UserService {
    public static final String TMP_PASSWORD = "123456";

    @Autowired
    private UserRepository userRepository;

    public Page<User> listUsers(Pageable pageable) {
        Predicate predicate = user.firstname.equalsIgnoreCase("dave")
                .and(user.lastname.startsWithIgnoreCase("mathews"));

        userRepository.findAll(predicate);

        return userRepository.findAll(pageable);
    }

    public User addUser(User user) {
        user.setPassword(TMP_PASSWORD);
        return userRepository.save(user);
    }

    public void update(String userId, List<String> roles) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
        // TODO check role name is exist
        user.setUserRoles(roles.stream().map(UserRole::new).collect(Collectors.toList()));
        userRepository.save(user);
    }
}
