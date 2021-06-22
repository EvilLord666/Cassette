package com.github.cassette.managers;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountManager implements IResourceManager<AccountEntity> {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Override
    public AccountEntity create(AccountEntity accountEntity) {
        return getDbContext().getAccountDataSource().save(accountEntity);
    }

    @Override
    public AccountEntity update(AccountEntity accountEntity) {
        Optional<AccountEntity> currentAccount = getDbContext().getAccountDataSource().findById(accountEntity.getId());
        if (currentAccount.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        return getDbContext().getAccountDataSource().save(accountEntity);
    }


    @Override
    public void deleteById(long id) {
        Optional<AccountEntity> accountEntityOptional = getDbContext().getAccountDataSource().findById(id);
        if (accountEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getAccountDataSource().delete(accountEntityOptional.get());
    }

    @Override
    public void delete(AccountEntity accountEntity) {
        Optional<AccountEntity> accountEntityOptional = getDbContext().getAccountDataSource().findById(accountEntity.getId());
        if (accountEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getAccountDataSource().delete(accountEntity);
    }

}