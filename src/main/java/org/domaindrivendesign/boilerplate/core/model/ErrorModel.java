package org.domaindrivendesign.boilerplate.core.model;

import lombok.Data;

@Data
public class ErrorModel {
    protected final String code;

    public ErrorModel(String code) {
        this.code = code;
    }
}
