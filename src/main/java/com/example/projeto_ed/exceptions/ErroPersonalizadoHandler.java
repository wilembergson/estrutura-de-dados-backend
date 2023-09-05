package com.example.projeto_ed.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroPersonalizadoHandler {
    @ExceptionHandler(ErroPadrao.class)
    public ResponseEntity<String> handleResourceNotFoundException(ErroPadrao ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
