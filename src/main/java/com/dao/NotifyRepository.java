package com.dao;

import com.core.domain.entities.Notify;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
public interface NotifyRepository {
    List<Notify> getAllNotifies();
    List<Notify> getLastNotifies();
    void addNotify(Notify notify);
}
