package com.github.cassette.model.repositories;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.RockNRollDbContext;
import com.github.cassette.model.entities.AccountEntity;
import com.github.cassette.utils.data.AccountCheckData;
import com.github.cassette.utils.checker.AccountSimpleChecker;
import com.github.cassette.utils.FunctionalTestBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("functests")
public class TestAccountRepository extends FunctionalTestBase {

    @Test
    public void testGetAll() throws Exception{
        List<AccountEntity> actualAccounts = dbContext.getAccountDataSource().findAll();
        List<AccountCheckData> expectedAccs = new ArrayList<>() {{
            add(new AccountCheckData(1L, "user1", "password1"));
            add(new AccountCheckData(2L, "user2", "password2"));
            add(new AccountCheckData(3L, "user3", "password3"));
        }};
        AccountSimpleChecker.check(expectedAccs, actualAccounts);
    }

    @Test
    public void testGetById() throws Exception{
        AccountEntity actual = dbContext.getAccountDataSource().findById(1L).orElseThrow();
        AccountCheckData expected = new AccountCheckData(1L, "user1", "password1");
        AccountSimpleChecker.check(expected, actual);

        actual = dbContext.getAccountDataSource().findById(3L).orElseThrow();
        expected = new AccountCheckData(3L, "user3", "password3");
        AccountSimpleChecker.check(expected, actual);
   }

    @Autowired
    IDbContext dbContext;
}
