package com.dao;

import com.core.domain.entities.Schedule;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
public interface ScheduleRepository {
    List<Schedule> getAllSchedules();
    Schedule getScheduleByID(Long id);
    Schedule getScheduleByName(String name);
    void removeSchedule(Long id);
    void addSchedule(Schedule schedule);
    void updateSchedule(Schedule schedule);
}
