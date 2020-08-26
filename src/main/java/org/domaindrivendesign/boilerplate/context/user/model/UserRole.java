package org.domaindrivendesign.boilerplate.context.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private String id;

    private User user;

    private Role role;

    private Instant createdAt;
}
