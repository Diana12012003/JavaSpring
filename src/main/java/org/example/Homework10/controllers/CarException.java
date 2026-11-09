package org.example.Homework10.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class CarException{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getFieldError().getDefaultMessage();

        return ResponseEntity.badRequest().body("Помилка валідації: " + message);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
