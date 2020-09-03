package org.domaindrivendesign.boilerplate.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.domaindrivendesign.boilerplate.core.exception.ErrorCode;

import java.util.Set;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorModel {
    protected final String code;

    protected final Set<String> fields;

    protected final String message;

    public ErrorModel(String code) {
        this.code = code;
        this.fields = null;
        this.message = null;
    }

    public ErrorModel(String code, Set<String> fields) {
        this.code = code;
        this.fields = fields;
        this.message = null;
    }

    public ErrorModel(ErrorCode code) {
        this.code = code.name();
        this.fields = null;
        this.message = code.getDescription();
    }
}
