package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Account on 13.01.2017.
 */
@Entity
public class DayOfWeek {

    @Id
    @GeneratedValue
    private Long id;
    private ArrayList<Class> classes;
    private int dayofweek;

    public DayOfWeek() {
    }

    public DayOfWeek(ArrayList<Class> classes, int dayofweek) {
        this.classes = classes;
        this.dayofweek = dayofweek;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}