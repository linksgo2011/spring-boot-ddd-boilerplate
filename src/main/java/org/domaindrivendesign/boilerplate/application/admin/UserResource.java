package org.domaindrivendesign.boilerplate.application.admin;

import org.domaindrivendesign.boilerplate.application.admin.cases.QueryUserCase;
import org.domaindrivendesign.boilerplate.context.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Page<QueryUserCase.Response> listUsers(
            QueryUserCase.UserCriteria userCriteria,
            Pageable pageable
    ) {
        return QueryUserCase.assemble(userService.listUsers(pageable));
    }
}
