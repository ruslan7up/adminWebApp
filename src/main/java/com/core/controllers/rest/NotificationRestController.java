package com.core.controllers.rest;

import com.core.domain.entities.MobileToken;
import com.core.services.MobileTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Created by ruslan on 30.01.2017.
 */
@RestController
@RequestMapping(value = "/notificationRest")
public class NotificationRestController {

    @Autowired
    private MobileTokenService service;

    @Autowired
    private ObjectMapper mapper;

    private final String AUTH_KEY = "AIzaSyBint8ilw16Xp_0qhXv-FF4uk0Mpza1wP0";


    @RequestMapping(value = "/registerDevice", method = RequestMethod.GET)
    public void registerPhone(@RequestParam String token) {
        service.addNewToken(token);
    }

    @RequestMapping(value = "/sendNotification", method = RequestMethod.GET)
    public void sendNotification(@RequestParam String message, HttpSession session,HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            if(message!=null && !message.isEmpty()) {
            try {
                String tokens = "{\"to\":\"fK04_ui_bus:APA91bFIL0vaFkQ5HALXnH5aNBjOo4fztRxQUQGoF7DGkZwU5_3u3zY-HCaXluKODrJR6xEjA91xIH0CjigoG4nH-YlFKPS9saJ-zjuSGc_f52ILZrSe0b5ls0wa-Kv9oX27iOmiX0mw\",\"data\":{\"hello\":\"friend\"}}";
                URL url = new URL("https://fcm.googleapis.com/fcm/send");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setDoOutput(true);
                http.setRequestMethod("POST");
                http.setRequestProperty("Content-Type","application/json");
                http.setRequestProperty("Authorization", "key="+AUTH_KEY);
                try(OutputStreamWriter os = new OutputStreamWriter(http.getOutputStream())) {
                    os.write(tokens);
                    os.flush();
                } catch (Exception e) {
                    System.out.println("OS EXCEPTION CATCHED "+e.getMessage());
                }

                System.out.println(http.getResponseCode());
            } catch (Exception e) {
                System.out.println("EXCEPTION CATCHED "+e.getMessage());
            }} else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
