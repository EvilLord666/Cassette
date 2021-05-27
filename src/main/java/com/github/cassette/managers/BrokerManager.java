package com.github.cassette.managers;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.BrokerEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BrokerManager implements IResourceManager<BrokerEntity> {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Override
    public BrokerEntity create(BrokerEntity brokerEntity) {
        return getDbContext().getBrokerDataSource().save(brokerEntity);
    }

    @Override
    public BrokerEntity update(BrokerEntity brokerEntity) {
        Optional<BrokerEntity> currentBroker = getDbContext().getBrokerDataSource().findById(brokerEntity.getId());
        if (currentBroker.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        return getDbContext().getBrokerDataSource().save(brokerEntity);
    }


    @Override
    public void deleteById(long id) {
        Optional<BrokerEntity> brokerEntityOptional = getDbContext().getBrokerDataSource().findById(id);
        if (brokerEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getBrokerDataSource().delete(brokerEntityOptional.get());
    }

    @Override
    public void delete(BrokerEntity brokerEntity) {
        Optional<BrokerEntity> brokerEntityOptional = getDbContext().getBrokerDataSource().findById(brokerEntity.getId());
        if (brokerEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getBrokerDataSource().delete(brokerEntity);
    }

}
