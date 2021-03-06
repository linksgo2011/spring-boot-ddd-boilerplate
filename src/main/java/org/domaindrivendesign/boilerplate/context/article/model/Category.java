package org.domaindrivendesign.boilerplate.context.article.model;

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
public class Category {
    private String id;

    private String name;

    private Instant updateAt;

    private Instant createdAt;
}
