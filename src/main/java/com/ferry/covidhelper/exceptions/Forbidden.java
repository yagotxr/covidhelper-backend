package com.ferry.covidhelper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ResponseStatus(FORBIDDEN)
public class Forbidden extends RuntimeException {

    public Forbidden(String msg) {
        super(msg);
    }
}
