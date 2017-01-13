package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by User on 13.01.2017.
 */
@Entity
public class Notify {
    @Id
    @GeneratedValue
    private Long id;
    private String notifymessage;

    public Notify() {
    }

    public Notify(String notifymessage) {
        this.notifymessage = notifymessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotifymessage() {
        return notifymessage;
    }

    public void setNotifymessage(String notifymessage) {
        this.notifymessage = notifymessage;
    }

}
