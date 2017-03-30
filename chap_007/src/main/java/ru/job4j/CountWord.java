package ru.job4j;

/**
 * @author Aleksandr Smirnov.
 */
public class CountWord implements Runnable {


    private String string;

    public CountWord(String string) {
        this.string = string;
    }

    public int getCountWord() {
        String[] strings = string.split(" ");
        return strings.length;
    }

    @Override
    public void run() {

        System.out.format("%s%s\n", "Кол-во слов - ", this.getCountWord());
    }
}
