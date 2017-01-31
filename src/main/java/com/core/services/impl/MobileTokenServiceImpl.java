package com.core.services.impl;

import com.core.domain.entities.MobileToken;
import com.core.services.MobileTokenService;
import com.dao.MobileTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ruslan on 30.01.2017.
 */
@Service
public class MobileTokenServiceImpl implements MobileTokenService {

    @Autowired
    private MobileTokenRepository repository;

    @Override
    public void addNewToken(String token) {
        MobileToken mobileToken = new MobileToken(token);
        repository.addNewToken(mobileToken);
    }

    @Override
    public List<MobileToken> getAllTokens() {
        return repository.getAllTokens();
    }
}
