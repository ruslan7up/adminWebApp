package com.core.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Date date;
    @Column(columnDefinition = "text")
    private String text;

    @OneToMany(mappedBy = "news")
    private List<Link> links;

    public News() {
    }

    public News(String title, Date date, String text, List<Link> links) {
        this.title = title;
        this.date = date;
        this.text = text;
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
