package com.core.services.impl;

import com.core.domain.entities.Class;
import com.core.domain.entities.Schedule;
import com.core.services.ScheduleService;
import com.dao.ClassRepository;
import com.dao.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Account on 13.01.2017.
 */

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private ClassRepository classrepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return repository.getAllSchedules();
    }

    @Override
    public Schedule getScheduleByName(String name) {
        return repository.getScheduleByName(name);
    }

    @Override
    public Schedule getScheduleByID(Long id) {
        return repository.getScheduleByID(id);
    }


    @Override
    public void addSchedule(Schedule schedule) {
        List<List<Class>> list = new ArrayList<>();
        list.add(schedule.getMonday());
        list.add(schedule.getTuesday());
        list.add(schedule.getWednesday());
        list.add(schedule.getThursday());
        list.add(schedule.getFriday());
        for (List<Class> tmp: list) {
            for (Class tmp2: tmp) {
                tmp2.setSchedule(schedule);
            }
        }
        repository.addSchedule(schedule);

    }

    @Override
    public void updateSchedule(Schedule schedule) {
        classrepository.removeClass(schedule.getId());
        repository.updateSchedule(schedule);
    }

    @Override
    public void removeSchedule(Long id) {
        Schedule schedule = getScheduleByID(id);
        schedule.getMonday().clear();
        schedule.getTuesday().clear();
        schedule.getWednesday().clear();
        schedule.getThursday().clear();
        schedule.getFriday().clear();
        updateSchedule(schedule);
        classrepository.removeClass(id);
        repository.removeSchedule(id);
    }
}
