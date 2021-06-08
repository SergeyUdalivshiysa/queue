package ru.volegov.messagequeue.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoElementsException extends RuntimeException{
    public NoElementsException(String message) {
        super(message);
    }

}
