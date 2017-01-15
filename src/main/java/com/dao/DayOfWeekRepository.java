package com.dao;

import com.core.domain.entities.DayOfWeek;

/**
 * Created by Account on 13.01.2017.
 */
public interface DayOfWeekRepository {
    void addDayOfWeek(DayOfWeek dayOfWeek);
    void removeDayOfWeek(Long id);
}
