package org.domaindrivendesign.boilerplate.application.admin;

import org.domaindrivendesign.boilerplate.application.admin.cases.ListUsers;
import org.domaindrivendesign.boilerplate.context.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<ListUsers.Response> listUsers() {
        return ListUsers.assemble(userService.listUsers());
    }
}
