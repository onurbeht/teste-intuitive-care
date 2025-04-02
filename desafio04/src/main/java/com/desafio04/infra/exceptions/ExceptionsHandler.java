package com.desafio04.infra.exceptions;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<String> handlePropertyReferenceException(PropertyReferenceException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handlePropertyReferenceException(Exception ex) {
        return ResponseEntity.internalServerError().build();
    }
    

}
