package com.core.controllers.rest;

import com.core.domain.entities.Notify;
import com.core.services.NotifyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by ruslan on 30.01.2017.
 */
@RestController
@RequestMapping(value = "/notificationRest")
public class NotificationRestController {

    @Autowired
    private NotifyService notifyService;

    @Autowired
    private ObjectMapper mapper;

    private final String AUTH_KEY = "AIzaSyC8VGMfZhYJIRd8sMIiMumZUh6sPEqC1kU";


    @RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
    public void sendNotification(@RequestParam String message, HttpSession session,HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            if(message!=null && !message.isEmpty()) {
            try {
                String data = "{\"to\":\"/topics/notifications\",\"data\":{\"message\":\""+message+"\"}}";
                URL url = new URL("https://fcm.googleapis.com/fcm/send");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setDoOutput(true);
                http.setRequestMethod("POST");
                http.setRequestProperty("Content-Type","application/json");
                http.setRequestProperty("Authorization", "key="+AUTH_KEY);
                try(OutputStream os = http.getOutputStream()) {
                    os.write(data.getBytes("UTF-8"));
                    os.flush();
                } catch (Exception e) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                if(http.getResponseCode()==200) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    notifyService.addNotify(new Notify(message, new Date()));
                } else {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
            }} else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @RequestMapping(value = "/getLastNotifications", method = RequestMethod.GET)
    private List<Notify> getLastNotifications() {
        return notifyService.getLastNotifies();
    }
}
