package org.domaindrivendesign.boilerplate.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Set;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorModel {
    protected final String code;

    protected final Set<String> fields;

    public ErrorModel(String code) {
        this.code = code;
        this.fields = null;
    }

    public ErrorModel(String code, Set<String> fields) {
        this.code = code;
        this.fields = fields;
    }
}
