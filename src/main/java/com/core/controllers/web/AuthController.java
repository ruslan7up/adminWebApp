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
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void authUser(@RequestParam String login, @RequestParam String pass, HttpSession session, HttpServletResponse response) {
        if (login != null && pass != null) {
            Account account = authService.getAccountByLogin(login);
            if (account != null) {
                PasswordEncoder passEncoder = new BCryptPasswordEncoder(6);
                String hashedPass = passEncoder.encode(pass);
                System.out.println(pass);
                System.out.println(passEncoder.matches(pass, hashedPass));
                if (passEncoder.matches(pass,hashedPass)) {
                    session.setAttribute("user", account);
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
        } else {
            return;
        }
    }
}
