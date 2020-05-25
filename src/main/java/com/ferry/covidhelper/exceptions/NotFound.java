package com.ferry.covidhelper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class NotFound extends RuntimeException {

    public NotFound(String message) {
        super(message);
    }
}
