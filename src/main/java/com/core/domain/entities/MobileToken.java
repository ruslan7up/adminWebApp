package com.core.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ruslan on 30.01.2017.
 */
@Entity
public class MobileToken {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String token;

    public MobileToken() {
    }

    public MobileToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
