package org.domaindrivendesign.boilerplate.core;


import org.springframework.util.StringUtils;

public enum ErrorCode {
    not_found(404);

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
