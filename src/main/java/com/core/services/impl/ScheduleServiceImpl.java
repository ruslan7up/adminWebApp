package com.core.services.impl;

import com.core.domain.entities.Schedule;
import com.core.services.ScheduleService;
import com.dao.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> getAllSchedules() {
        return repository.getAllSchedules();
    }

    @Override
    public Schedule getScheduleByID(Long id) {
        return repository.getScheduleByID(id);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        repository.addSchedule(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        repository.updateSchedule(schedule);
    }

    @Override
    public void removeSchedule(Long id) {
        repository.removeSchedule(id);
    }
}
