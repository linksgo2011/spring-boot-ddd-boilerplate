package org.domaindrivendesign.boilerplate.core.exception;


import org.springframework.util.StringUtils;

public enum ErrorCode {
    INTERNAL_ERROR(500),
    NOT_FOUND(404),
    USER_NOT_FOUND(404, "User is not found in system."),
    METHOD_NOT_ALLOWED(405),
    INVALID_PARAMS(400);

    private int statusCode;

    private String description;

    public String getDescription() {
        return description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    ErrorCode(int statusCode) {
        this.statusCode = statusCode;
    }

    ErrorCode(int statusCode,String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public static ErrorCode of(String type) {
        if (StringUtils.isEmpty(type.trim())) {
            throw new RuntimeException("no such error code");
        }
        return ErrorCode.valueOf(type);
    }
}
