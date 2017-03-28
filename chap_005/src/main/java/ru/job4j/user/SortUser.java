package ru.job4j.user;

import java.util.*;

/**
 * @author Aleksandr Smirnov.
 */
public class SortUser {
    /**
     * Метод сортировки по возрасту.
     *
     * @param list - коллекция.
     * @return - Set коллекция.
     */

    public Set<User> sortByAge(List<User> list) {
        Collections.sort(list);
        Set<User> set = new TreeSet<>();
        for (User a : list) {
            set.add(a);
        }
        return set;
    }

    /**
     * Метод сортировки по длине имени.
     *
     * @param list - коллекция.
     * @return collection -  ArrayList коллекция.
     */
    public List<User> sortByNameLength(List<User> list) {
        Collections.sort(list, new UserLengthNameComparator());
        List<User> collection = new ArrayList<>();
        for (User a : list) {
            collection.add(a);
        }
        return collection;
    }

    /**
     * Метод сортировки по хэш-коду.
     *
     * @param list - коллекция.
     * @return collection - ArrayList коллекция.
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new UserHashCodeComparator());
        List<User> collection = new ArrayList<>();
        for (User a : list) {
            collection.add(a);
        }
        return collection;
    }
}
