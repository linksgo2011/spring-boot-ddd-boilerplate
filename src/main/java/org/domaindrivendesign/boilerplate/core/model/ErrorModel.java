package org.domaindrivendesign.boilerplate.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
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
