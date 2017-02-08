package com.dao;

import com.core.domain.entities.News;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
public interface NewsRepository {

    public List<News> getNewsByPageNumber(int page);
    public Integer getNumberOfPages();
    public void addNews(News news);
    public void removeNews(Long id);
}
