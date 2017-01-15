package com.core.controllers.web;

import com.core.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {

        return new ModelAndView("schedulelist");
    }

    @RequestMapping(value = "/updateschedule", method = RequestMethod.GET)
    public ModelAndView getUpdateSchedulePage() {

        return null;
    }

    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    public ModelAndView getAddSchedulePage() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("action","add");
        return new ModelAndView("schedule", modelMap);
    }

    @RequestMapping(value = "/removeschedule", method = RequestMethod.GET)
    public void removeSchedule(@RequestParam String id, HttpSession session, HttpServletResponse response) {

    }

    @RequestMapping(value = "/addschedule", method = RequestMethod.POST)
    public void addSchedule(@RequestParam String json, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {

        } else
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
