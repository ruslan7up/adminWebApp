package com.core.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Account on 13.01.2017.
 */
@Entity
public class Class {
    @Id
    @GeneratedValue
    private Long id;

    private String nameofasubject;
    private String cabinetnumber;

    public Class() {
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
}
