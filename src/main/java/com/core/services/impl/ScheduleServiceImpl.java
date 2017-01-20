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
        for (List<Class> tmp:list) {
            for (Class clazz:tmp) {
                clazz.setSchedule(schedule);
            }
        }
        classrepository.addClass(list);
        repository.addSchedule(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        repository.updateSchedule(schedule);
    }

    @Override
    public void removeSchedule(Long id) {
        classrepository.removeClass(id);
        repository.removeSchedule(id);
    }
}
