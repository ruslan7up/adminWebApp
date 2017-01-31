package com.core.services;

import com.core.domain.entities.MobileToken;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ruslan on 30.01.2017.
 */
public interface MobileTokenService {
    void addNewToken(String token);
    List<MobileToken> getAllTokens();
}
