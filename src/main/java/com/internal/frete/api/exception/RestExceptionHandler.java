package com.internal.frete.api.exception;

import com.internal.frete.api.dto.ErroSimplesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    private ResponseEntity illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        ErroSimplesResponse erroSimplesResponse = new ErroSimplesResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroSimplesResponse);
    }
}
