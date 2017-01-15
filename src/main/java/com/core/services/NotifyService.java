package com.core.services;

import com.core.domain.entities.Notify;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
public interface NotifyService {
    List<Notify> getAllNotifies();
    List<Notify> getLastNotifies();
    void addNotify(Notify notify);
}
