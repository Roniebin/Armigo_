package org.example.virtualfittingshop.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class AppException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
