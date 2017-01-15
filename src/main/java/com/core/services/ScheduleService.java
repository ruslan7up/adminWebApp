package com.core.services;

import com.core.domain.entities.Schedule;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Schedule getScheduleByID(Long id);
    void addSchedule(Schedule schedule);
    void updateSchedule(Schedule schedule);
    void removeSchedule(Long id);
 }
