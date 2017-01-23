package com.core.controllers.web;

import com.core.domain.entities.Schedule;
import com.core.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    public ModelAndView getSchedulePage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            List<Schedule> list = service.getAllSchedules();
            ModelMap modelMap = new ModelMap();
            modelMap.put("schedules", list);
            return new ModelAndView("schedulelist", modelMap);
        } else {
            return new ModelAndView("authpage");
        }
    }

    @RequestMapping(value = "/updateschedule/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateSchedulePage(@PathVariable("id") String id, HttpSession session) {
        if(session.getAttribute("user")!=null) {
            ModelMap modelMap = new ModelMap();
            modelMap.put("action", "edit");
            modelMap.put("schedule", service.getScheduleByID(Long.parseLong(id)));
            return new ModelAndView("schedule", modelMap);
        } else {
            return new ModelAndView("authpage");
        }
    }

    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    public ModelAndView getAddSchedulePage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            ModelMap modelMap = new ModelMap();
            modelMap.put("action", "add");
            return new ModelAndView("schedule", modelMap);
        } else {
            return new ModelAndView("authpage");
        }
    }
}
