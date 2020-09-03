package org.domaindrivendesign.boilerplate.core.exception;

public class BusinessException extends BaseException {

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }
}
