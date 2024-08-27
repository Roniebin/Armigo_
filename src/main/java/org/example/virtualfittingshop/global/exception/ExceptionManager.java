package org.example.virtualfittingshop.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionManager  {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> appExceptionHandler(AppException e){
        return new ResponseEntity<>(createErrorResponse(e),e.getStatus());
    }

    public Map<String,Object> createErrorResponse(AppException e){
        Map<String,Object> body = new HashMap<>();
        body.put("errorCode", e.getStatus());
        body.put("errorMessage", e.getMessage());
        return body;
    }
}
