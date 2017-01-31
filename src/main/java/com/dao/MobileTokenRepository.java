package com.dao;

import com.core.domain.entities.MobileToken;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ruslan on 30.01.2017.
 */
public interface MobileTokenRepository {
    public void addNewToken(MobileToken token);
    public List<MobileToken> getAllTokens();
}
