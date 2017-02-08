package com.dao;

import com.core.domain.entities.Link;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
public interface NewsLinksRepository {

    void addLink(List<Link> link);
    void removeLink(Long id);
}
