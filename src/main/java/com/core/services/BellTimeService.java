package com.core.services;

import com.core.domain.entities.BellTime;
import com.core.domain.entities.Schedule;

import java.util.List;

/**
 * Created by ruslan on 14.01.2017.
 */
public interface BellTimeService {
    List<BellTime> getBellTime();
    void updateBellSchedule(List<BellTime> list);
}
