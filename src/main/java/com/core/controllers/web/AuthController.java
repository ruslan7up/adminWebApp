package com.core.controllers.web;

import com.core.domain.entities.Account;
import com.core.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ruslan on 14.01.2017.
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void authUser(@RequestParam String login, @RequestParam String pass, HttpSession session, HttpServletResponse response) {
        if (login != null && pass != null) {
            Account account = service.getAccountByLogin(login);
            if (account != null) {
                if (encoder.matches(pass,account.getPassword())) {
                    session.setAttribute("user", account);
                } else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logoutUser(HttpSession session,HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            session.removeAttribute("user");
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            }
        }
    }
}
