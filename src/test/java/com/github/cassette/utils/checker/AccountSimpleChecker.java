package com.github.cassette.utils.checker;

import com.github.cassette.model.entities.AccountEntity;
import com.github.cassette.utils.data.AccountCheckData;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

public class AccountSimpleChecker {

    public static void check(AccountCheckData expected, AccountEntity actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUserName(), actual.getUserName());
        Assert.assertEquals(expected.getPasswordHash(), actual.getPasswordHash());
        }

    public static void check(List<AccountCheckData> expected, List<AccountEntity> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        expected.forEach((item) -> {
            List<AccountEntity> selectedItems = actual.stream().filter(dbItem ->
                    dbItem.getId().equals(item.getId())).collect(Collectors.toList());
            Assert.assertEquals(1L, selectedItems.size());
            check(item, selectedItems.get(0));
        });
    }
}
