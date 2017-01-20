package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int shift;

    @OneToMany(mappedBy = "schedule")
    private List<Class> monday;
    @OneToMany(mappedBy = "schedule")
    private List<Class> tuesday;
    @OneToMany(mappedBy = "schedule")
    private List<Class> wednesday;
    @OneToMany(mappedBy = "schedule")
    private List<Class> thursday;
    @OneToMany(mappedBy = "schedule")
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
