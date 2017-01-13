package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by User on 13.01.2017.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    Long id;
    private ArrayList<DayOfWeek> days;
    private int shift;

    public Schedule() {
    }

    public Schedule(ArrayList<DayOfWeek> days, int shift) {
        this.days = days;
        this.shift = shift;
    }

    public ArrayList<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(ArrayList<DayOfWeek> days) {
        this.days = days;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
