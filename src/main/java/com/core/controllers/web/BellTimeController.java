package com.core.controllers.web;

import com.core.domain.entities.BellTime;
import com.core.services.BellTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
@RequestMapping("/belltime")
public class BellTimeController {

    @Autowired
    private BellTimeService service;

    @RequestMapping(value = "/belltimetable", method = RequestMethod.GET)
    public ModelAndView getBellTimePage() {
        List<BellTime> list = service.getBellTime();
        ModelMap modelMap = new ModelMap();
        modelMap.put("belltime", list);
        return new ModelAndView("belltimetable", modelMap);
    }
}
