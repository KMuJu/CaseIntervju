package com.KMuJu.CaseIntervju.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String,String>> handleBadRequestException(BadRequestException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("Error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
