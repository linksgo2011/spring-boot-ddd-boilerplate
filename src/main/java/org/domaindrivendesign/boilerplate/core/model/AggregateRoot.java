package org.domaindrivendesign.boilerplate.core.model;

import org.springframework.data.annotation.Id;

public class AggregateRoot {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
