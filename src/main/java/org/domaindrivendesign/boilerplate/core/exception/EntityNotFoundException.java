package org.domaindrivendesign.boilerplate.core.exception;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
