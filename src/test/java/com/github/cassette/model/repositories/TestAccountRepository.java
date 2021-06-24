package com.github.cassette.model.repositories;

import com.github.cassette.model.IDbContext;
import com.github.cassette.model.entities.AccountEntity;
import com.github.cassette.utils.data.AccountCheckData;
import com.github.cassette.utils.checker.AccountSimpleChecker;
import com.github.cassette.utils.FunctionalTestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
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

   @Test
   public void testCreateAccount() throws Exception{
        AccountEntity entity = new AccountEntity("user23", "pass12");
        entity = dbContext.getAccountDataSource().save(entity);
        Assert.assertNotNull(entity);
   }

   @Test
   public void testUpdateAccount() throws Exception{
       AccountEntity entity = dbContext.getAccountDataSource().findById(3L).orElseThrow();
       entity.setUserName("abrakadabra");
       entity = dbContext.getAccountDataSource().save(entity);
       AccountCheckData expected = new AccountCheckData(3L, "abrakadabra", "password3");
       AccountEntity testEntity = dbContext.getAccountDataSource().findById(3L).orElseThrow();
       AccountSimpleChecker.check(expected, testEntity);
   }
   @Test
   public void testDeleteAccount() throws Exception{
       AccountEntity entity = dbContext.getAccountDataSource().findById(3L).orElseThrow();
       dbContext.getAccountDataSource().delete(entity);
       Optional<AccountEntity> testAccount = dbContext.getAccountDataSource().findById(3L);
       if (testAccount.isEmpty()){
           Assert.assertNull(null);
       }
       else{
           Assert.assertNull(1);
       }
   }


    @Autowired
    IDbContext dbContext;
}
