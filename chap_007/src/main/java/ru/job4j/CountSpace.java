package ru.job4j;

/**
 * @author Aleksandr Smirnov.
 */
public class CountSpace implements Runnable {
    private String string;

    public CountSpace(String string) {
        this.string = string;
    }

    public int getCountSpace() {
        String[] strings = string.split(" ");
        return strings.length - 1;
    }

    @Override
    public void run() {
        System.out.format("%s%s\n", "Кол-во пробелов - ", this.getCountSpace());
    }

}
