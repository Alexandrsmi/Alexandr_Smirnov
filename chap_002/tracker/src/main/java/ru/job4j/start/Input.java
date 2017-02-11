package ru.job4j.start;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 30.01.2017.
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
