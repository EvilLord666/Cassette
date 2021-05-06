package com.github.cassette.model;

import com.github.cassette.model.repositories.IMessageRepository;
import com.github.cassette.model.repositories.IMessageStatusRepository;

public interface IDbContext {
    IMessageRepository getMessageDataSource();

    IMessageStatusRepository getMessageStatusDataSource();
}
