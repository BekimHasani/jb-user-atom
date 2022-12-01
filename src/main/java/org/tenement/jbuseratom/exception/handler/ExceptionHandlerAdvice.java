package org.tenement.jbuseratom.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tenement.jbuseratom.exception.ValidationException;
import org.tenement.jbuseratom.exception.response.ValidationExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationExceptionResponse> handleValidationException(ValidationException ex){
        ValidationExceptionResponse response = new ValidationExceptionResponse(HttpStatus.BAD_REQUEST, ex.getErrors());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
