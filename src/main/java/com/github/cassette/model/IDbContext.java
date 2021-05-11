package com.github.cassette.model;

import com.github.cassette.model.repositories.*;

public interface IDbContext {
    
    IAccountRepository getAccountDataSource();
    
    IBrokerTypeRepository getBrokerTypeDataSource();
    
    IBrokerRepository getBrokerDataSource();
    
    IMessageRepository getMessageDataSource();

    IMessageStatusRepository getMessageStatusDataSource();
}
