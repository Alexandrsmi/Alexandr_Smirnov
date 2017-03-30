package ru.job4j.bank;

import java.util.*;

/**
 * @author Aleksandr Smirnov.
 */
public class BankLogic {
    /**
     * Коллекция счетов пользователей.
     */
    private final Map<UserOfBank, List<Accounts>> userState;

    /**
     * Конструктор по умолчанию.
     */
    public BankLogic(final Map<UserOfBank, List<Accounts>> userState) {
        this.userState = userState;
    }

    /**
     * Метод добавляет пользователя.
     *
     * @param user - пользователь.
     */

    public void addUser(UserOfBank user) {
        userState.put(user, null);
    }

    /**
     * Метод удаляет пользователя.
     *
     * @param user
     */
    public void deleteUser(UserOfBank user) {
        userState.remove(user);
    }

    /**
     * Метод добавляет счет пользователю.
     *
     * @param user    - пользователь.
     * @param account - счет.
     */
    public void addAccountToUser(UserOfBank user, Account account) {
        if (userState.get(user) == null) {
            userState.put(user, new ArrayList<>());
            userState.get(user).add(account);
        } else {
            userState.get(user).add(account);
        }
    }

    /**
     * Метод удаляет счет пользователя.
     *
     * @param user    - пользователь.
     * @param account - счет.
     */
    public void deleteAccountFromUser(UserOfBank user, Account account) {
        userState.get(user).remove(account);
    }

    /**
     * Медот выдает список счетов пользователя.
     *
     * @param user
     * @return - список счетов.
     */
    public List<Accounts> getUserAccounts(UserOfBank user) {
        List<Accounts> list = userState.get(user);
        return list;
    }

    /**
     * Метод переводит средства с одного счета на другой.
     *
     * @param srcUser    - отправитель.
     * @param srcAccount - счет отправителя.
     * @param dstUser    - получатель.
     * @param dstAccount - счет получателя.
     * @param amount     - сумма перевода.
     * @return - true - перевод состоялся, false - ошибка при переводе.
     */
    public boolean transferMoney(UserOfBank srcUser, Account srcAccount, UserOfBank dstUser, Account dstAccount, double amount) {
        if (srcAccount != null && dstAccount != null && srcAccount.hashCode() != dstAccount.hashCode()) {
            for (Accounts accounts : userState.get(srcUser)) {
                if (accounts.hashCode() == srcAccount.hashCode() && srcAccount.getValues() - amount >= 0) {
                    srcAccount.setValues(srcAccount.getValues() - amount);
                    for (Accounts account : userState.get(dstUser)) {
                        if (account.hashCode() == dstAccount.hashCode()) {
                            dstAccount.setValues(dstAccount.getValues() + amount);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public Map<UserOfBank, List<Accounts>> getUserState() {
        return userState;
    }
}