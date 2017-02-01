package com.core.controllers.web;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by User on 31.01.2017.
 */
@Controller
public class SecurityController {

    @RequestMapping(value = "/changepass", method = RequestMethod.GET)
    public ModelAndView getChangePassPage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("changepassword");
        } else {
            return new ModelAndView("authpage");
        }
    }
}
