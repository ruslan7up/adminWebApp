package com.core.controllers.web;

import com.core.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 05.02.2017.
 */

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getpage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            ModelMap modelMap = new ModelMap();
            modelMap.put("news", service.getNewsByPageNumber(1));
            return new ModelAndView("newsadd", modelMap);
        } else {
            return new ModelAndView("authpage");
        }
    }
}
