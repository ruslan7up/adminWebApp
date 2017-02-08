package com.core.controllers.web;


import com.core.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * Created by ruslan on 24.01.2017.
 */

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/get")
    public ModelAndView getChatPage(HttpSession session) {
        if(session.getAttribute("user")!=null) {
            return new ModelAndView("chat");
        } else  {
            return new ModelAndView("authpage");
        }
    }



}
