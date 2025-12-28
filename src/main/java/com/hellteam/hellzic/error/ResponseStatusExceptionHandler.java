package com.hellteam.hellzic.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ResponseStatusExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleStatusException(ResponseStatusException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getStatusCode().value(),
                ((HttpStatus) ex.getStatusCode()).getReasonPhrase(),
                ex.getReason() // ← TON MESSAGE ICI
        );
        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}

record ErrorResponse(
        int status,
        String value,
        String message
) {
}
