package org.domaindrivendesign.boilerplate.application.admin.cases;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.domaindrivendesign.boilerplate.context.user.model.UserRole;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.time.Instant;
import java.util.List;

public class QueryUserCase {
    @Data
    @NoArgsConstructor
    public static class UserCriteria {
        private String username;

        private Boolean enabled;
    }

    @Data
    @NoArgsConstructor
    public static class Response {
        private String id;

        private String email;

        private String phone;

        private String username;

        private String fullName;

        private boolean enabled;

        private boolean emailVerified;

        private DateTime createdAt;

        private List<UserRole> userRoles;
    }

    public static Page<Response> toResponse(Page users) {
        return users.map(
                user -> new ModelMapper().map(users, Response.class)
        );
    }
}
