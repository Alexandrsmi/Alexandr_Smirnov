package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Aleksandr Smirnov.
 */
public class BankLogicTest {
    private final BankLogic bankLogic = new BankLogic(new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    private final List<UserOfBank> userList = bankLogic.getUserList();
    private final Map<UserOfBank, List<Accounts>> userState = bankLogic.getUserState();
    final UserOfBank userOfBank = new UserOfBank("Vasya", 12345);
    final UserOfBank userOfBank2 = new UserOfBank("Vasya", 123456);
    private final Account account = new Account(300, 1234555);
    private final Account account2 = new Account(400, 12345553);
    private final Account account3 = new Account(500, 12345554);
    private final Account account4 = new Account(600, 12345556);

    @Test
    public void addUser() {
        bankLogic.addUser(userOfBank);
        bankLogic.addUser(userOfBank2);
        Assert.assertTrue(userList.size() > 0);
    }

    @Test
    public void deleteUser() {
        bankLogic.deleteUser(userOfBank);
        Assert.assertTrue(userList.size() == 0);

    }

    @Test
    public void addAccountToUser() {
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account3);
        bankLogic.addAccountToUser(userOfBank, account4);
        Assert.assertTrue(userState.size() > 0);
    }

    @Test
    public void deleteAccountFromUser() {
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account3);
        int size = userState.get(userOfBank).size();
        bankLogic.deleteAccountFromUser(userOfBank, account);
        Assert.assertTrue(size > userState.get(userOfBank).size());
    }

    @Test
    public void getUserAccounts() {
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account2);
        List<Accounts> listExpected = userState.get(userOfBank);
        List<Accounts> list = new ArrayList<>();
        list.add(account);
        list.add(account2);
        Assert.assertTrue(list.equals(listExpected));
    }

    @Test
    public void transferMoney() {
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank2, account2);
        boolean result = bankLogic.transferMoney(userOfBank, account, userOfBank2, account2, 20);
        Assert.assertTrue(result);
    }
}