package org.domaindrivendesign.boilerplate.core;


import org.springframework.util.StringUtils;

public enum ErrorCode {
    INTERNAL_ERROR(500),
    NOT_FOUND(404),
    USER_NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INVALID_PARAMS(400);

    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    ErrorCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ErrorCode of(String type) {
        if (StringUtils.isEmpty(type.trim())) {
            throw new RuntimeException("no such error code");
        }
        return ErrorCode.valueOf(type);
    }
}
