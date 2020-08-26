package org.domaindrivendesign.boilerplate.context.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
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
