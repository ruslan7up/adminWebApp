package com.core.controllers.rest;

import com.core.domain.entities.BellTime;
import com.core.services.BellTimeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ruslan on 21.01.2017.
 */

@RestController
@RequestMapping("/bellTimeRest")
public class BellTimeRestController {

    @Autowired
    BellTimeService service;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateBellTime(@RequestParam String json, HttpSession session, HttpServletResponse response) throws IOException {
        if(session.getAttribute("user")!=null) {
            ArrayList<BellTime> list = new ObjectMapper().readValue(json, new TypeReference<ArrayList<BellTime>>(){});
            if(list!=null) {
                service.updateBellSchedule(list);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
