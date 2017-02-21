package com.core.controllers.error;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ruslan on 22.01.2017.
 */
@ControllerAdvice
public class ExceptionsController {
  /*  @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView getException(Throwable throwable)  {
       ModelMap modelMap = new ModelMap();
        modelMap.put("exception",throwable.getClass().getSimpleName()+":"+throwable.getMessage());
        return new ModelAndView("exception", modelMap);
    }*/
}
