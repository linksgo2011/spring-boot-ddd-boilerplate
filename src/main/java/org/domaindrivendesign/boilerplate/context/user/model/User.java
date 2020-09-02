package org.domaindrivendesign.boilerplate.context.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.domaindrivendesign.boilerplate.core.model.AggregateRoot;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AggregateRoot {
    private String email;

    private String phone;

    private String username;

    private String fullName;

    private String password;

    private boolean enabled;

    private boolean emailVerified;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    @MappedCollection(idColumn = "USER_ID", keyColumn = "ROLE_NAME")
    private List<UserRole> userRoles;
}
