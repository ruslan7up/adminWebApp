package com.core.controllers.web;

import com.core.services.BellTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
@RequestMapping("/belltime")
public class BellTimeController {

    @Autowired
    private BellTimeService bellTimeService;

    @RequestMapping(value = "/belltimetable", method = RequestMethod.GET)
    public ModelAndView getBellTimePage() {

        return null;
    }

    @RequestMapping(value = "/updatebelltime", method = RequestMethod.GET)
    public ModelAndView getUpdateBellTimePage() {

        return null;
    }
}
