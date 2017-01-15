package com.core.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Account on 13.01.2017.
 */
@Controller
public class HomeController  {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomePage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("home");
        } else {
            return new ModelAndView("authpage");
        }
    }
}
