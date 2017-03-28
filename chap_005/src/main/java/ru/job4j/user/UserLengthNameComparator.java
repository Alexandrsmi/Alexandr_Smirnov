package ru.job4j.user;

import java.util.Comparator;

/**
 * @author Aleksandr Smirnov.
 */
public class UserLengthNameComparator implements Comparator<User> {
    /**
     * Метод сортирует по длине имени.
     * @param o1 - объект.
     * @param o2 - объект.
     * @return
     */
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
