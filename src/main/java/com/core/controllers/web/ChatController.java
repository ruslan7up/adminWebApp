package com.core.controllers.web;


import com.core.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ruslan on 24.01.2017.
 */

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/get")
    public ModelAndView getChatPage() {

        return new ModelAndView("chat");
    }



}
