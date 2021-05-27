package com.github.cassette.controllers.api;

import com.github.cassette.dto.BrokerTypeDto;
import com.github.cassette.factories.BrokerTypeFactory;
import com.github.cassette.managers.IResourceManager;
import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.BrokerTypeEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BrokerTypeController extends BaseController {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Lookup
    public IResourceManager<BrokerTypeEntity> getResourceManager() {
        return null;
    }

    @GetMapping("api/brokertype")
    public List<BrokerTypeDto> getBrokerTypeDtos() {
        return getDbContext().getBrokerTypeDataSource().findAll().stream()
                .map(brokerTypeEntity -> BrokerTypeFactory.create(brokerTypeEntity))
                .collect(Collectors.toList());
    }

    @GetMapping("api/brokertype/{id}")
    public BrokerTypeDto getBrokerTypeDto(@PathVariable(name = "id") Long id) {
        BrokerTypeEntity brokerTypeEntity = getDbContext().getBrokerTypeDataSource()
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Broker type not found"));
        return BrokerTypeFactory.create(brokerTypeEntity);
    }

    @PostMapping("api/brokertype")
    public BrokerTypeDto createBrokerType(@RequestBody BrokerTypeEntity brokerTypeEntity) {
        BrokerTypeEntity entity = getResourceManager().create(brokerTypeEntity);
        return BrokerTypeFactory.create(entity);
    }

    @PutMapping("api/brokertype/id")
    public BrokerTypeDto updateBrokerType(@RequestBody BrokerTypeEntity brokerTypeEntity) {
        BrokerTypeEntity entity = getResourceManager().update(brokerTypeEntity);
        return BrokerTypeFactory.create(entity);
    }

    @DeleteMapping("api/brokertype/{id}")
    public ResponseEntity deleteBrokerType(@PathVariable(name = "id") Long id) {
        getResourceManager().deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
