package org.domaindrivendesign.boilerplate.application.admin.cases;

import lombok.Builder;
import lombok.Data;
import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.domaindrivendesign.boilerplate.context.user.model.UserRole;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ListUsers {

    @Builder
    @Data
    public static class Response {
        private String id;

        private String email;

        private String phone;

        private String username;

        private String fullName;

        private String password;

        private boolean enabled;

        private boolean emailVerified;

        private Instant createdAt;

        private List<UserRole> userRoles;
    }

    public static List<Response> assemble(List<User> users) {
        return Arrays.asList();
    }
}
