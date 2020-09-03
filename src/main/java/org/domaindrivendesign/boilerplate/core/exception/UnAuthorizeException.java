package org.domaindrivendesign.boilerplate.core.exception;

public class UnAuthorizeException extends BaseException{
    public UnAuthorizeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
