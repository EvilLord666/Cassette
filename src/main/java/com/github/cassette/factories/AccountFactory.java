package com.github.cassette.factories;

import com.github.cassette.dto.AccountDto;
import com.github.cassette.model.entities.AccountEntity;
public final class AccountFactory {
    public static AccountDto create(AccountEntity entity) {
        return new AccountDto(entity.getId(), entity.getUserName(), entity.getPasswordHash());
    }
}
