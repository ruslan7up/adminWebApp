package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by ruslan on 05.02.2017.
 */
@Entity
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String link;
    @OneToOne
    private News news;

    public Link(String link) {
        this.link = link;
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
}
