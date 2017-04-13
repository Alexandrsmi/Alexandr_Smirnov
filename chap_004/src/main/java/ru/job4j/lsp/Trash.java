package ru.job4j.lsp;

import ru.job4j.lsp.food.Food;

import java.util.Calendar;

/**
 * Класс мусорки.
 * @author Aleksandr Smirnov.
 */
public class Trash extends Storehouse {
    /**
     * Название хранилища.
     */
    private static final String NAME = "Trash";
    /**
     * Конструктор по умолчанию.
     */
    public Trash() {
        super(NAME);
    }
    /**
     * Метод проверяет продукт по сроку годности.
     * @param food - продукт.
     * @param calendar - текущая дата.
     * @return - true - если срок годности удовлетворяет требования хранилища,
     *           false - если срок годности не удовлетворяет тревания хранилища.
     */
    @Override
    public boolean checkFood(Food food, Calendar calendar) {
        if (food.getPercentByTime() >= getTR()) {
            return true;
        }
        return false;
    }
}