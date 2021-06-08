package ru.volegov.messagequeue.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerHandler(NullPointerException e) {
        return new ResponseEntity<>("No elements", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoElementsException.class)
    public ResponseEntity<String> noElementsHandler(NoElementsException e) {
        return new ResponseEntity<>("There are no elements...", HttpStatus.NOT_FOUND);
    }
}


