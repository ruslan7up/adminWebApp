package com.core.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 01.02.2017.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ModelAndView getNotificationSendPage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("notification");
        } else {
            return new ModelAndView("authpage");
        }
    }
}
