package com.core.services.impl;

import com.core.domain.entities.News;
import com.core.services.NewsService;
import com.dao.NewsLinksRepository;
import com.dao.repositories.NewsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

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
        linksRepository.addLink(news.getLinks());
    }

    @Override
    public void removeNews(Long id) {
        repository.removeNews(id);
        linksRepository.removeLink(id);
    }
}
