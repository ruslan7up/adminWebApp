package com.core.domain.entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

/**
 * Created by Account on 13.01.2017.
 */

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;
    private int shift;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderColumn(name = "mon")
    @JoinTable(name = "mon")
    private List<Class> monday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderColumn(name = "tue")
    @JoinTable(name = "tue")
    private List<Class> tuesday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderColumn(name = "wed")
    @JoinTable(name = "wed")
    private List<Class> wednesday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderColumn(name = "thu")
    @JoinTable(name = "thu")
    private List<Class> thursday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderColumn(name = "fri")
    @JoinTable(name = "fri")
    private List<Class> friday;

    public Schedule() {
    }

    public Schedule(String name, int shift, List<Class> monday, List<Class> tuesday, List<Class> wednesday, List<Class> thursday, List<Class> friday) {
        this.name = name;
        this.shift = shift;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public List<Class> getMonday() {
        return monday;
    }

    public void setMonday(List<Class> monday) {
        this.monday = monday;
    }

    public List<Class> getTuesday() {
        return tuesday;
    }

    public void setTuesday(List<Class> tuesday) {
        this.tuesday = tuesday;
    }

    public List<Class> getWednesday() {
        return wednesday;
    }

    public void setWednesday(List<Class> wednesday) {
        this.wednesday = wednesday;
    }

    public List<Class> getThursday() {
        return thursday;
    }

    public void setThursday(List<Class> thursday) {
        this.thursday = thursday;
    }

    public List<Class> getFriday() {
        return friday;
    }

    public void setFriday(List<Class> friday) {
        this.friday = friday;
    }
}