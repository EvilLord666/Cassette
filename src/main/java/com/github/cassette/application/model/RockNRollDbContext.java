package com.github.cassette.application.model;

import com.github.cassette.application.model.repositories.IMessageRepository;
import com.github.cassette.application.model.repositories.IMessageStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class RockNRollDbContext implements IDbContext {

    @Autowired
    private IMessageRepository iMessageRepository;
    @Autowired
    private IMessageStatusRepository iMessageStatusRepository;

    @Override
    public IMessageRepository getMessageDataSource() {
        return iMessageRepository;
    }

    @Override
    public IMessageStatusRepository getMessageStatusDataSource() {
        return iMessageStatusRepository;
    }
}
