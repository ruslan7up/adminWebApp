package com.core.services;

import com.core.domain.entities.Substitution;

import java.util.Date;
import java.util.List;

/**
 * Created by ruslan on 24.05.2017.
 */
public interface LessonService {
    List<Substitution> getSubstitutions(Date date);
    void deleteSubstitution(long id);
    void addSubstitution(Substitution substitution);
}
