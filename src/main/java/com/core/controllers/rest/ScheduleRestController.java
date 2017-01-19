package com.core.controllers.rest;

import com.core.domain.entities.Schedule;
import com.core.services.ScheduleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ruslan on 19.01.2017.
 */
@RestController
@RequestMapping("/scheduleRest")
public class ScheduleRestController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addSchedule(@RequestParam String json, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            Schedule schedule = null;
            try {
                schedule = new ObjectMapper().readValue(json, Schedule.class);
            } catch (IOException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                System.out.println(e.getMessage());
                return;
            }
            System.out.println("ЙА СМОГ!");
            System.out.println(schedule.getMonday().get(0).getNameofasubject()+schedule.getMonday().get(0).getCabinetnumber());
        } else
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void removeSchedule(@RequestParam String id, HttpSession session, HttpServletResponse response) {

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateSchedule(@RequestParam String json, HttpSession session, HttpServletResponse response) {

    }
}
