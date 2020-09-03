package org.domaindrivendesign.boilerplate.core.exception;


public class BadParameterException extends BaseException {

    public BadParameterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
