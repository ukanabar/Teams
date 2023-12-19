package com.uk.teams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
      
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> blogNotFoundException(EntityNotFoundException entityNotFoundException) {
        return new ResponseEntity<String>(entityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
   
}