package com.github.cassette.factories;

import com.github.cassette.dto.BrokerDto;
import com.github.cassette.model.entities.BrokerEntity;

public final class BrokerFactory {
    public static BrokerDto create(BrokerEntity brokerEntity){
        return new BrokerDto();
    }
}
