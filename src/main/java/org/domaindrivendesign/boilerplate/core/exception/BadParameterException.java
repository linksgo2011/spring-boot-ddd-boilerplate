package org.domaindrivendesign.boilerplate.core.exception;


import org.domaindrivendesign.boilerplate.core.ErrorCode;

public class BadParameterException extends BaseException {

    public BadParameterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
