package com.core.controllers.web;

import com.core.domain.entities.Notify;
import com.core.services.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ruslan on 01.02.2017.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotifyService service;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ModelAndView getNotificationSendPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            List<Notify> list = service.getLastNotifies();
            ModelMap modelMap = new ModelMap();
            modelMap.put("notifications",list);
            return new ModelAndView("notification", modelMap);
        } else {
            return new ModelAndView("authpage");
        }
    }
}