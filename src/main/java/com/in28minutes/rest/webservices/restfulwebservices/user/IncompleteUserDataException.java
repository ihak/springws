package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncompleteUserDataException extends RuntimeException {

    public IncompleteUserDataException(String arg0) {
        super(arg0);
    }
}
