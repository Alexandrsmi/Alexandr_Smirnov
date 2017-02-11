package ru.job4j;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 05.02.2017.
 */
public class Cell {
    Cell cell = new Cell();
    private String name = "da";
    /**
     * false - пустая, true - фигура
     */
    private boolean state;



    public void setState(boolean state) {
        this.state = state;
    }
}
