package com.core.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {


    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {
        return new ModelAndView("schedulelist");
    }

    @RequestMapping(value = "/updateschedule", method = RequestMethod.GET)
    public ModelAndView getUpdateSchedulePage(@RequestParam String id) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("action","edit");
        return new ModelAndView("schedule", modelMap);
    }

    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    public ModelAndView getAddSchedulePage() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("action","add");
        return new ModelAndView("schedule", modelMap);
    }
}
