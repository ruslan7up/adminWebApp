package com.core.controllers.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ruslan on 22.01.2017.
 */
@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String getException(Throwable throwable)  {
       return "exception";
    }
}
