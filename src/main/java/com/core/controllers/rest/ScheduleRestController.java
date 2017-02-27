package com.core.controllers.rest;

import com.core.domain.entities.Class;
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
import java.util.ArrayList;
import java.util.List;

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
                schedule.setName(schedule.getName().toUpperCase());
            } catch (IOException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            scheduleService.addSchedule(schedule);
            response.setStatus(HttpServletResponse.SC_OK);
        } else
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void removeSchedule(@RequestParam String id, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null){
            scheduleService.removeSchedule(Long.parseLong(id));

        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateSchedule(@RequestParam String json, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            Schedule schedule = null;
            try {
                schedule = new ObjectMapper().readValue(json, Schedule.class);
            } catch (IOException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            scheduleService.updateSchedule(schedule);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @RequestMapping(value = "/getByName", method = RequestMethod.POST)
    public Schedule getScheduleByName(@RequestParam String name, HttpSession session,HttpServletResponse response) {
        System.out.println(name);
        if(name!=null && !name.isEmpty()) {
                return scheduleService.getScheduleByName(name.toUpperCase());
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }

        return null;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public List<Schedule> getAllSchedules(HttpSession session,HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            return scheduleService.getAllSchedules();
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        return new ArrayList<>();
    }
}