package org.domaindrivendesign.boilerplate.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.domaindrivendesign.boilerplate.core.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class BusinessAdvice {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorModel> onError(BaseException exception) {
        log.error("error, code: {}", exception.getErrorCode(), exception);

        ErrorModel errorModel = new ErrorModel(exception.getErrorCode().name());
        return ResponseEntity.status(exception.getErrorCode().getStatusCode()).body(errorModel);
    }
}
