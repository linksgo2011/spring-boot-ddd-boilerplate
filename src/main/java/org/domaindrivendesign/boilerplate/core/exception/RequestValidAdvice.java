package org.domaindrivendesign.boilerplate.core.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.domaindrivendesign.boilerplate.core.ErrorCode;
import org.domaindrivendesign.boilerplate.core.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestControllerAdvice
public class RequestValidAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorModel> unknownError(BindException exception) {
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INTERNAL_ERROR.name()
        ));
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(BindException exception) {
        return response(exception.getAllErrors());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(MethodArgumentNotValidException exception) {
        return response(exception.getBindingResult().getAllErrors());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(ConstraintViolationException exception) {
        Set<String> fieldErrors = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(NumberFormatException exception) {
        Set<String> fieldErrors = Collections.singleton("invalid_param_format");
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<ErrorModel> onRequestParamError(InvalidFormatException exception) {
        Set<String> fieldErrors = Collections.singleton("invalid_param_format");
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name()
        ));
    }

    private ResponseEntity<ErrorModel> response(List<ObjectError> allErrors) {
        Set<String> errors = allErrors.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toSet());
        return ResponseEntity.status(ErrorCode.INVALID_PARAMS.getStatusCode()).body(new ErrorModel(
                ErrorCode.INVALID_PARAMS.name(),
                errors
        ));
    }
}
