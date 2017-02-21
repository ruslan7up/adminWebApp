package com.core.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ruslan on 05.02.2017.
 */
@Entity
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String link;

    @NotNull
    @OneToOne
    private News news;

    public Link(String link, News news) {
        this.link = link;
        this.news = news;
    }

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
