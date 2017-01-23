package com.dao;

import com.core.domain.entities.BellTime;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
public interface BellTimeRepository {
    List<BellTime> getBellTime();
    void updateBellTime(List<BellTime> bellTime);
}
