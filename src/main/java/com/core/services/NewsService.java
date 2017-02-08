package com.core.services;

import com.core.domain.entities.News;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
public interface NewsService {
    List<News> getNewsByPageNumber(int page);
    Integer getNumberOfPages();
    void addNews(News news);
    void removeNews(Long id);
}
