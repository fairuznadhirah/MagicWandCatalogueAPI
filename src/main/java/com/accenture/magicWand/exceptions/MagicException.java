package com.accenture.magicWand.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MagicException extends RuntimeException{

    public static final String INVALID_EXIST_WIZARD = "Error: Wizard with id does not exist";

    public MagicException(String message){
        super(message);
    }
}
