package com.core.controllers.rest;

import com.core.domain.entities.Substitution;
import com.core.services.LessonService;
import com.core.services.impl.LessonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ruslan on 24.05.2017.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsRestController {

    @Autowired
    private LessonServiceImpl service;


    @RequestMapping(value = "/getubstitutions", method = RequestMethod.GET)
    public List<Substitution> getSubstitutions(@RequestParam String date) {
        long dateMs = Long.parseLong(date);
        Date res = new Date(dateMs);
        List<Substitution> list = service.getSubstitutions(res);
        return list;
    }

    @RequestMapping(value = "/addsubstitution", method = RequestMethod.GET)
    public void addSubstitution(@RequestParam String substition, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            ObjectMapper parser = new ObjectMapper();
            try {
                System.out.println(substition);
                Substitution subs = parser.readValue(substition, Substitution.class);
                System.out.println(subs.getDate().toString());
                System.out.println(subs.getGroupName());
                System.out.println(subs.getLesson1());
                System.out.println(subs.getLesson2());
                service.addSubstitution(subs);
            } catch (IOException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                System.out.println("ERR "+e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @RequestMapping(value = "/deletesubstitution", method = RequestMethod.GET)
    public void deleteSubstitiution(@RequestParam String id, HttpSession session, HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            service.deleteSubstitution(Integer.parseInt(id));
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
