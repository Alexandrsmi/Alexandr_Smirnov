package ru.job4j;

import org.junit.Test;
import ru.job4j.user.SortUser;
import ru.job4j.user.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksandr Smirnov.
 */
public class SortUserTest {
    /**
     * Тест сортировки по возрасту.
     */
    @Test
    public void sortByAge() {
        User user2 = new User(2, "55555", "c", (byte) 11);
        User user3 = new User(3, "333", "f", (byte) 12);
        User user = new User(1, "4444", "b", (byte) 10);
        List<User> users = new LinkedList<>();
        users.add(user3);
        users.add(user);
        users.add(user2);
        SortUser sortUser = new SortUser();
        Set<User> actualList = sortUser.sortByAge(users);
        Set<User> expectedList= new TreeSet<>();
        expectedList.add(user);
        expectedList.add(user2);
        expectedList.add(user3);
        assertThat(expectedList,is(actualList));
    }

    /**
     * Тест сортировки по длине имени.
     */
    @Test
    public void sortByNameLength() {
        User user2 = new User(2, "55555", "c", (byte) 11);
        User user3 = new User(3, "333", "f", (byte) 12);
        User user = new User(1, "4444", "b", (byte) 10);
        List<User> users = new LinkedList<>();
        users.add(user);
        users.add(user3);
        users.add(user2);
        SortUser sortUser = new SortUser();
        List<User> actualList = sortUser.sortByNameLength(users);
        List<User> expectedList= new ArrayList<>();
        expectedList.add(user3);
        expectedList.add(user);
        expectedList.add(user2);
        assertThat(expectedList,is(actualList));

    }

    /**
     * Тест сортировки по хеш-коду.
     */
    @Test
    public void sortHash() {
        User user2 = new User(2, "55555", "c", (byte) 11);
        User user3 = new User(3, "333", "f", (byte) 12);
        User user = new User(1, "4444", "b", (byte) 10);
        List<User> users = new LinkedList<>();
        users.add(user);
        users.add(user3);
        users.add(user2);
        SortUser sortUser = new SortUser();
        List<User>  actualList = sortUser.sortHash(users);
        List<User> expectedList= new ArrayList<>();
        expectedList.add(user3);
        expectedList.add(user);
        expectedList.add(user2);
        assertThat(expectedList,is(actualList));
    }
}
