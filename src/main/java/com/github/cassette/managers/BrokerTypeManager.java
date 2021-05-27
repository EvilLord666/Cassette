package com.github.cassette.managers;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.BrokerTypeEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BrokerTypeManager implements IResourceManager<BrokerTypeEntity> {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Override
    public BrokerTypeEntity create(BrokerTypeEntity brokerTypeEntity) {
        return getDbContext().getBrokerTypeDataSource().save(brokerTypeEntity);
    }

    @Override
    public BrokerTypeEntity update(BrokerTypeEntity brokerTypeEntity) {
        Optional<BrokerTypeEntity> currentBrokerType = getDbContext().getBrokerTypeDataSource().findById(brokerTypeEntity.getId());
        if (currentBrokerType.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        return getDbContext().getBrokerTypeDataSource().save(brokerTypeEntity);
    }


    @Override
    public void deleteById(long id) {
        Optional<BrokerTypeEntity> brokerTypeEntityOptional = getDbContext().getBrokerTypeDataSource().findById(id);
        if (brokerTypeEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getBrokerTypeDataSource().delete(brokerTypeEntityOptional.get());
    }

    @Override
    public void delete(BrokerTypeEntity brokerTypeEntity) {
        Optional<BrokerTypeEntity> brokerTypeEntityOptional = getDbContext().getBrokerTypeDataSource().findById(brokerTypeEntity.getId());
        if (brokerTypeEntityOptional.isEmpty()) {
            throw new RuntimeException("Record not found");
        }
        getDbContext().getBrokerTypeDataSource().delete(brokerTypeEntity);
    }

}
