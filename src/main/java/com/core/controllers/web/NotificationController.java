package com.core.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 31.01.2017.
 */
@Controller
@RequestMapping(value = "/notification")
public class NotificationController {

    @RequestMapping(value = "/sendnotification", method = RequestMethod.GET)
    public ModelAndView getSendNotificationPage(HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("notification");
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return new ModelAndView("authpage");
        }
    }
}
