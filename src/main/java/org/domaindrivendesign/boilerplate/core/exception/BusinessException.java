package org.domaindrivendesign.boilerplate.core.exception;

import org.domaindrivendesign.boilerplate.core.ErrorCode;

public class BusinessException extends BaseException {

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }
}
