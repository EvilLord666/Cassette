package com.github.cassette.controllers.api;

import com.github.cassette.dto.AccountDto;
import com.github.cassette.factories.AccountFactory;
import com.github.cassette.managers.IResourceManager;
import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController extends BaseController {

    @Lookup
    public IDbContext getDbContext() {
        return null;
    }

    @Lookup
    public IResourceManager<AccountEntity> getResourceManager() {
        return null;
    }

    @GetMapping("api/account")
    public List<AccountDto> getAllAccountDtos() {
        return getDbContext().getAccountDataSource().findAll().stream().map(accountEntity -> AccountFactory.create(accountEntity))
                .collect(Collectors.toList());
    }

    @GetMapping("api/account/{id}")
    public AccountDto getAccountDtoByID(@PathVariable(name = "id") Long id) {
        AccountEntity accountEntity = getDbContext().getAccountDataSource().findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountFactory.create(accountEntity);
    }

    @PostMapping("api/account")
    public AccountDto createAccount(@RequestBody AccountEntity accountEntity) {
        AccountEntity entity = getResourceManager().create(accountEntity);
        return AccountFactory.create(entity);
    }

    @PutMapping("api/account/id")
    public AccountDto updateAccount(@RequestBody AccountEntity accountEntity) {
        AccountEntity entity = getResourceManager().update(accountEntity);
        return AccountFactory.create(entity);
    }

    @DeleteMapping("api/account/{id}")
    public ResponseEntity deleteAccount(@PathVariable(name = "id") Long id) {
        getResourceManager().deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}