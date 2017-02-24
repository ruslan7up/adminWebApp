package com.core.services.impl;

import com.core.domain.entities.Link;
import com.core.domain.entities.News;
import com.core.services.NewsService;
import com.dao.NewsLinksRepository;
import com.dao.repositories.NewsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("")+"/WEB-INF";

    @Autowired
    private NewsRepositoryImpl repository;

    @Autowired
    private NewsLinksRepository linksRepository;

    @Override
    public List<News> getNewsByPageNumber(int page) {
        if(page>0) {
            return repository.getNewsByPageNumber(page);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Integer getNumberOfPages() {
        return repository.getNumberOfPages();
    }

    @Override
    public void addNews(News news) {
        repository.addNews(news);
    }

    @Override
    public void removeNews(Long id) {
        News news = repository.getNewsById(id);
        for (Link link:news.getLinks()) {
            try {
                Files.deleteIfExists(Paths.get(path + link.getLink()));
            } catch (Exception e) {
                System.out.println("EXCEPTION "+e.getMessage());
            }
        }
        linksRepository.removeLink(id);
        repository.removeNews(id);
    }
}
