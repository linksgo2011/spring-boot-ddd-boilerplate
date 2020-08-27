package org.domaindrivendesign.boilerplate.application.admin.cases;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.time.Instant;

public class QueryUserCase {
    @Data
    @NoArgsConstructor
    public static class UserCriteria {
        private String username;

        private Boolean enabled;
    }

    @Builder
    @Data
    public static class Response {
        private String id;

        private String email;

        private String phone;

        private String username;

        private String fullName;

        private boolean enabled;

        private boolean emailVerified;

        private Instant createdAt;
    }

    public static Page<Response> assemble(Page users) {
        return users.map(
                user -> new ModelMapper().map(users, Response.class)
        );
    }
}
