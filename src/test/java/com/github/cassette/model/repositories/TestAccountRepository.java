package com.github.cassette.model.repositories;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.AccountEntity;
import com.github.cassette.utils.data.AccountCheckData;
import com.github.cassette.utils.checker.AccountSimpleChecker;
import com.github.cassette.utils.FunctionalTestBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

@SpringBootTest
@ActiveProfiles("functests")
public class TestAccountRepository extends FunctionalTestBase {

    @Test
    public void testGetAll() throws Exception{
        Iterable<AccountEntity> accountIterable = dbContext.getAccountDataSource().findAll();
        Iterator<AccountEntity> it = accountIterable.iterator();
        List<AccountEntity> actualAccounts = new ArrayList<>();
        while (it.hasNext()) {
            actualAccounts.add(it.next());
        }
        List<AccountCheckData> expectedAccs = new ArrayList<>() {{
            add(new AccountCheckData(1L, "user1", "password1"));
            add(new AccountCheckData(2L, "user2", "password2"));
            add(new AccountCheckData(3L, "user2", "password2"));
        }};
        AccountSimpleChecker.check(expectedAccs, actualAccounts);
    }

    @Test
    public void testGetById() throws Exception{
        AccountEntity actual = dbContext.getAccountDataSource().findById(1L).get();
        //AccountEntity actual = new AccountEntity();
        AccountCheckData expected = new AccountCheckData(1L, "user1", "password1");
        AccountSimpleChecker.check(expected, actual);

        actual = dbContext.getAccountDataSource().findById(3L).get();
        expected = new AccountCheckData(3L, "user3", "password3");
        AccountSimpleChecker.check(expected, actual);
   }

    @Autowired
    IDbContext dbContext;
}
