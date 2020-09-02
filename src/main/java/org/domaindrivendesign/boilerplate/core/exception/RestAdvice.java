package org.domaindrivendesign.boilerplate.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.domaindrivendesign.boilerplate.core.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestAdvice {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorModel> onError(BaseException exception) {
        log.error("error, code: {}", exception.getErrorCode(), exception);

        ErrorModel errorModel = new ErrorModel(exception.getErrorCode().name());
        return ResponseEntity.status(exception.getErrorCode().getStatusCode()).body(errorModel);
    }

//    @ExceptionHandler(value = {ConstraintViolationException.class})
//    public ResponseEntity handleBadInput(ConstraintViolationException ex) {
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
}
