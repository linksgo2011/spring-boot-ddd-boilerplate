package org.domaindrivendesign.boilerplate.application.admin.cases;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;

public class AddUserCase {
    @Data
    @NoArgsConstructor
    public static class Request {
        private String email;

        private String phone;

        private String username;

        private String fullName;

        private boolean enabled;
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
    }

    public static User toUser(Request request) {
        return new ModelMapper().map(request, User.class);
    }

    public static Response toResponse(User user) {
        return new ModelMapper().map(user, Response.class);
    }
}
