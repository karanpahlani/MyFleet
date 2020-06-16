package com.fleet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.GONE)
public class EmployeeAlreadyExists extends RuntimeException{

    public EmployeeAlreadyExists(String message){
        super(message);
    }
}
