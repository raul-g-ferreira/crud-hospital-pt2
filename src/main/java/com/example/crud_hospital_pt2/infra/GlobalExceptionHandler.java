package com.example.crud_hospital_pt2.infra;

import com.example.crud_hospital_pt2.exception.WardAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WardAlreadyExistsException.class)
    public ResponseEntity<RestExceptionResponse> handleWardAlreadyExistsException(WardAlreadyExistsException e) {
        RestExceptionResponse response = new RestExceptionResponse(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestExceptionResponse> handleNotFoundException(Exception e) {
        RestExceptionResponse errorMessage = new RestExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
