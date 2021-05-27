package com.github.cassette.controllers.api;

import com.github.cassette.dto.BrokerDto;
import com.github.cassette.factories.BrokerFactory;
import com.github.cassette.managers.IResourceManager;
import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.BrokerEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BrokerController extends BaseController {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Lookup
    public IResourceManager<BrokerEntity> getResourceManager() {
        return null;
    }

    @GetMapping("api/broker")
    public List<BrokerDto> getBrokerDtos() {
        return getDbContext().getBrokerDataSource().findAll().stream()
                .map(brokerEntity -> BrokerFactory.create(brokerEntity))
                .collect(Collectors.toList());
    }

    @GetMapping("api/broker/{id}")
    public BrokerDto getBrokerDto(@PathVariable(name = "id") Long id) {
        BrokerEntity brokerEntity = getDbContext().getBrokerDataSource()
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Broker not found"));
        return BrokerFactory.create(brokerEntity);
    }

    @PostMapping("api/broker")
    public BrokerDto createBroker(@RequestBody BrokerEntity brokerEntity) {
        BrokerEntity entity = getResourceManager().create(brokerEntity);
        return BrokerFactory.create(entity);
    }

    @PutMapping("api/broker/id")
    public BrokerDto updateBroker(@RequestBody BrokerEntity brokerEntity) {
        BrokerEntity entity = getResourceManager().update(brokerEntity);
        return BrokerFactory.create(entity);
    }

    @DeleteMapping("api/broker/{id}")
    public ResponseEntity deleteBroker(@PathVariable(name = "id") Long id) {
        getResourceManager().deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
