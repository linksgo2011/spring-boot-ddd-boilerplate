package org.domaindrivendesign.boilerplate.core.exception;

import org.domaindrivendesign.boilerplate.core.ErrorCode;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
