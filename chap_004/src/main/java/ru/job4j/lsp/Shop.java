package ru.job4j.lsp;

import ru.job4j.lsp.food.Food;

import java.util.Calendar;

/**
 * Класс магазина.
 * @author Aleksandr Smirnov.
 */
public class Shop extends Storehouse {
    /**
     * Название хранилища.
     */
    private static final String NAME = "Shop";

    /**
     * Конструктор по умолчанию.
     */
    public Shop() {
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

        if (food.getPercentByTime() < getMaxExpiredShelfLife() &&
                food.getPercentByTime() > getMinExpiredShelfLife()) {
            return true;
        } else if (food.getPercentByTime() >= getMaxExpiredShelfLife() &&
                food.getPercentByTime() < getTR()) {
            food.setPrice(food.getPrice() * food.getDiscount());//если срок годности истёк больше  чем на 75%
            return true;                                        // делаем скидку на продукт.
        }
        return false;
    }
}
