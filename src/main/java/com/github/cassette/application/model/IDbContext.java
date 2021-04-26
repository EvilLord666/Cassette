package com.github.cassette.application.model;

import com.github.cassette.application.model.repositories.IMessageRepository;
import com.github.cassette.application.model.repositories.IMessageStatusRepository;

public interface IDbContext {
    IMessageRepository getMessageDataSource();

    IMessageStatusRepository getMessageStatusDataSource();
}
