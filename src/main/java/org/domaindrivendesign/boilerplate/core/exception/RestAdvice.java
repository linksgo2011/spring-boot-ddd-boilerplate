package org.domaindrivendesign.boilerplate.core.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.domaindrivendesign.boilerplate.core.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Uniform error output, define the error advice here
 */
@Slf4j
@RestControllerAdvice
public class RestAdvice {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorModel> onError(BaseException exception) {
        log.error("error, code: {}", exception.getErrorCode(), exception);

        ErrorModel errorModel = new ErrorModel(exception.getErrorCode());
        return ResponseEntity.status(exception.getErrorCode().getStatusCode()).body(errorModel);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(HttpRequestMethodNotSupportedException exception) {
        log.info("error", exception);
        return ResponseEntity.status(ErrorCode.METHOD_NOT_ALLOWED.getStatusCode()).body(new ErrorModel(
                ErrorCode.METHOD_NOT_ALLOWED.name()
        ));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(HttpMessageNotReadableException exception) {
        log.info("error", exception);
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(MethodArgumentNotValidException exception) {
        log.info("error", exception);
        Set<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toSet());
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name(),
                errors
        ));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(ConstraintViolationException exception) {
        log.info("error", exception);
        Set<String> fieldErrors = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name(),
                fieldErrors
        ));
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(NumberFormatException exception) {
        log.info("error", exception);
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(InvalidFormatException exception) {
        log.info("error", exception);
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorModel> unknownError(Exception exception) {
        log.info("error", exception);

        return buildErrorResponse();
    }

    private ResponseEntity<ErrorModel> buildErrorResponse() {
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INTERNAL_ERROR.name()
        ));
    }
}
