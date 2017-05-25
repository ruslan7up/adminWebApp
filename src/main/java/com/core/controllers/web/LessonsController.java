package com.core.controllers.web;

import com.core.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 24.05.2017.
 */
@Controller
public class LessonsController {

    @RequestMapping(value = "/lessonspage", method = RequestMethod.GET)
    public ModelAndView getLessonsPage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("lessons");
        } else {
            return new ModelAndView("authpage");
        }
    }
}
