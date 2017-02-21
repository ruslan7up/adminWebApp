package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Account on 13.01.2017.
 */
@Entity
public class Notify {
    @Id
    @GeneratedValue
    private Long id;
    private String notifymessage;
    private Date date;

    public Notify() {
    }

    public Notify(String notifymessage, Date date) {
        this.notifymessage = notifymessage;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
