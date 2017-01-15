package com.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Account on 13.01.2017.
 */
@Entity
public class BellTime {
    @Id
    private Long id;
    private String startTime;
    private String endTime;

    public BellTime() {
    }

    public BellTime(Long id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
