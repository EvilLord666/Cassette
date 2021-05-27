package com.github.cassette.factories;

import com.github.cassette.dto.BrokerTypeDto;
import com.github.cassette.model.entities.BrokerTypeEntity;

public final class BrokerTypeFactory {
    public static BrokerTypeDto create(BrokerTypeEntity brokerTypeEntity){
        return new BrokerTypeDto();
    }
}
