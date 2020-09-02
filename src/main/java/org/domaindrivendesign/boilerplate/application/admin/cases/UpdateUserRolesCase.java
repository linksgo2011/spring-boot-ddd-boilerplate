package org.domaindrivendesign.boilerplate.application.admin.cases;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.domaindrivendesign.boilerplate.context.user.model.User;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UpdateUserRolesCase {
    @Data
    @NoArgsConstructor
    public static class Request {
        private List<String> roles;
    }
}
