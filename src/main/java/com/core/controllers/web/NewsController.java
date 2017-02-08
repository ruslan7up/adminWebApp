package com.core.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 05.02.2017.
 */

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getpage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return "newsadd";
        } else {
            return "authpage";
        }
    }
}
