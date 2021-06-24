package com.github.cassette.model;

import com.github.cassette.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("request")
public class RockNRollDbContext implements IDbContext {

    @Override
    public IMessageRepository getMessageDataSource() {
        return this.messageRepo;
    }

    @Override
    public IMessageStatusRepository getMessageStatusDataSource() {
        return this.messageStatusRepo;
    }
    
    @Override
    public IAccountRepository getAccountDataSource() {
        return this.accountRepo;
    }

    @Override
    public IBrokerTypeRepository getBrokerTypeDataSource() {
        return this.brokerTypeRepo;
    }

    @Override
    public IBrokerRepository getBrokerDataSource() {
        return this.brokerRepo;
    }
    
    @Autowired
    private IAccountRepository accountRepo;
    @Autowired
    private IBrokerTypeRepository brokerTypeRepo;
    @Autowired
    private IBrokerRepository brokerRepo;
    @Autowired
    private IMessageRepository messageRepo;
    @Autowired
    private IMessageStatusRepository messageStatusRepo;
}
