package org.domaindrivendesign.boilerplate.context.article.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String id;

    private String title;

    private String content;

    private String author;

    private Instant updateAt;

    private Instant createdAt;
}
