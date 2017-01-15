package com.core.services.impl;

import com.core.domain.entities.BellTime;
import com.core.domain.entities.Schedule;
import com.core.services.BellTimeService;
import com.dao.BellTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ruslan on 14.01.2017.
 */
@Service
public class BellTImeServiceImpl implements BellTimeService {

    @Autowired
    private BellTimeRepository repository;

    @Override
    public List<BellTime> getBellTime() {
        return repository.getBellTime();
    }

    @Override
    public void updateBellSchedule(List<BellTime> list) {
        for (BellTime tmp: list) {
            repository.updateBellTime(tmp);
        }
    }
}
