package com.dao;

import com.core.domain.entities.Class;

/**
 * Created by ruslan on 15.01.2017.
 */
public interface ClassRepository {
    void addClass(Class clazz);
    void removeClass(Long id);
}
