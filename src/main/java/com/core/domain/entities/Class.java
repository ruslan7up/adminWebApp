package com.core.domain.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by User on 13.01.2017.
 */
@Entity
public class Class {
    @Id
    @GeneratedValue
    private Long id;

    private Long classnumber;
    private String nameofasubject;
    private String cabinetnumber;

    public Class() {
    }

    public Class(Long classnumber,String nameofasubject, String cabinetnumber) {
        this.classnumber = classnumber;
        this.nameofasubject = nameofasubject;
        this.cabinetnumber = cabinetnumber;
    }

    public String getNameofasubject() {
        return nameofasubject;
    }

    public void setNameofasubject(String nameofasubject) {
        this.nameofasubject = nameofasubject;
    }

    public String getCabinetnumber() {
        return cabinetnumber;
    }

    public void setCabinetnumber(String cabinetnumber) {
        this.cabinetnumber = cabinetnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(Long classnumber) {
        this.classnumber = classnumber;
    }
}
