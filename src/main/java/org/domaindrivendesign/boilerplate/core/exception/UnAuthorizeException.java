package org.domaindrivendesign.boilerplate.core.exception;

import org.domaindrivendesign.boilerplate.core.ErrorCode;

public class UnAuthorizeException extends BaseException{
    public UnAuthorizeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
