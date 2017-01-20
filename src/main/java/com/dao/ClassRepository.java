package com.dao;

import com.core.domain.entities.Class;

import java.util.List;

/**
 * Created by ruslan on 15.01.2017.
 */
public interface ClassRepository {
    void addClass(List<List<Class>> clazz);
    void removeClass(Long id);
}
