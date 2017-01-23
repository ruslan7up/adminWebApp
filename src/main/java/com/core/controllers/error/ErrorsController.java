package com.core.controllers.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ruslan on 12.01.2017.
 */
@Controller
@RequestMapping("/errors")
public class ErrorsController {

    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public ModelAndView get404page() {
        return  new ModelAndView("page404");
    }
}
