package com.core.controllers.rest;

import com.core.domain.entities.Link;
import com.core.domain.entities.News;
import com.core.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ruslan on 05.02.2017.
 */

@RestController
public class NewsRestController {

    private String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("")+"/WEB-INF/resources/newsres/";

    @Autowired
    private NewsService service;

    @RequestMapping(value = "/createnews", method = RequestMethod.POST)
    public void uploadFile(@RequestParam List<MultipartFile> file,@RequestParam String title, @RequestParam String text, HttpSession session, HttpServletResponse response) throws Exception {
        if(session.getAttribute("user")!=null) {
            if(file!=null && !file.isEmpty()) {
                List<Link> links = new ArrayList<>();
                News news = new News(new String(title.getBytes("ISO-8859-1"),"UTF-8"),new Date(),new String(text.getBytes("ISO-8859-1"),"UTF-8"),links);
                try {
                    for (MultipartFile tmp:file) {
                        if(!tmp.isEmpty() && tmp!=null && tmp.getOriginalFilename().matches("^.*\\.(png|bmp|jpg|jpeg)$")) {
                            byte[] bytes = tmp.getBytes();
                            String filename = tmp.getOriginalFilename();
                            String extension = filename.substring(filename.lastIndexOf("."),filename.length());
                            String name = generateNewUUID(extension);
                            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path+name+extension)));
                            stream.write(bytes);
                            stream.close();
                            links.add(new Link("/resources/newsres/"+name+extension,news));
                        }
                    }

                    service.addNews(news);
                    response.setStatus(HttpServletResponse.SC_OK);
                } catch (Exception e) {
                    System.out.println("EXCEPTION "+e.getMessage());
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } else {
                List<Link> links = new ArrayList<>();
                try {
                    Date date = new Date();
                    News news = new News(new String(title.getBytes("ISO-8859-1"),"UTF-8"),date,new String(text.getBytes("ISO-8859-1"),"UTF-8"),links);
                    service.addNews(news);
                    response.setStatus(HttpServletResponse.SC_OK);
                } catch (Exception e) {
                    System.out.println("EXCEPTION " + e.getMessage());
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            }
            
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    private String generateNewUUID(String extension) {
        String UUID = java.util.UUID.randomUUID().toString().replaceAll("-","");
        if(Files.exists(Paths.get(path+UUID+extension), LinkOption.NOFOLLOW_LINKS) ) {
            generateNewUUID(extension);
        }
        return UUID;
    }

    @RequestMapping(value = "/getNews/{page}", method = RequestMethod.GET)
    public List<News> getNews(@PathVariable("page") String page) {
        List<News> list = service.getNewsByPageNumber(Integer.parseInt(page));
        return list;
    }

    @RequestMapping(value = "/getNumberOfPages", method = RequestMethod.GET)
    public Integer getNumberOfPages() {
        return service.getNumberOfPages();
    }

    @RequestMapping(value = "/delNews", method = RequestMethod.POST)
    public void delNews(@RequestParam String id, HttpSession session,HttpServletResponse response) {
        if(session.getAttribute("user")!=null) {
            service.removeNews(Long.parseLong(id));
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}