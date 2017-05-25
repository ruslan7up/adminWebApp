package com.core.services.impl;

import com.core.domain.entities.Substitution;
import com.core.services.LessonService;
import com.dao.LessonRepository;
import com.dao.repositories.LessonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ruslan on 24.05.2017.
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepositoryImpl repository;

    @Override
    public List<Substitution> getSubstitutions(Date date) {
        return repository.getSubstitutions(date);
    }

    @Override
    public void deleteSubstitution(long id) {
        repository.deleteSubstitution(id);
    }

    @Override
    public void addSubstitution(Substitution substitution) {
        repository.addSubstitution(substitution);
    }
}
