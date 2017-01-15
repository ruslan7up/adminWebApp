package com.core.services.impl;

import com.core.domain.entities.Notify;
import com.core.services.NotifyService;
import com.dao.NotifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */

@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private NotifyRepository repository;

    @Override
    public List<Notify> getAllNotifies() {
        return repository.getLastNotifies();
    }

    @Override
    public List<Notify> getLastNotifies() {
        return repository.getLastNotifies();
    }

    @Override
    public void addNotify(Notify notify) {
        repository.addNotify(notify);
    }
}
