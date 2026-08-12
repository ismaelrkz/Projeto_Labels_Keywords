package br.ismaelreckziegel.labels_keywords.controller;

import br.ismaelreckziegel.labels_keywords.exceptions.ConflictException;
import br.ismaelreckziegel.labels_keywords.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflict(ConflictException ex){
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(500).body("An unexpected error occurred on our servers. Please try again later.");
    }

}
