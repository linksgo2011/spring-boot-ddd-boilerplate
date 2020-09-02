package org.domaindrivendesign.boilerplate.core.exception;

import org.domaindrivendesign.boilerplate.core.ErrorCode;

public class BaseException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
