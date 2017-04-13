package ru.job4j.lsp;

import ru.job4j.lsp.food.Curd;
import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.food.Milk;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Класс распределения продуктов.
 * @author Aleksandr Smirnov.
 */
public class ControlQuality {
    /**
     * Массив хранилищь.
     */
    private static Storehouse[] storegs = {
            new Warehouse(),
            new Shop(),
            new Trash()
    };
    /**
     * Лист хранилиз
     */
    private List<Storehouse> list = new ArrayList<>();
    /**
     * Конструктор по умолчанию.
     */
    public ControlQuality() {
    }
    /**
     * Метод определяет на какой склад направить продукт.
     * @param food
     */
    public void addFoodOnStorehouse(Food food) {
        //проверяем продукт на складе, если продукт в наличии и его срок
        // годности не для склада false - удаляем продукт со склада.
        for (Storehouse s : storegs) {
            if (!s.checkFood(food, new GregorianCalendar()) && s.getStoregs().contains(food)) {
                s.getStoregs().remove(food);
                break;
            }
        }//добавляем продукт на склад.
        for (Storehouse storeg : storegs) {
            if (storeg.checkFood(food, new GregorianCalendar())) {
                list.add(storeg);
                storeg.getStoregs().add(food);
                break;
            }
        }
    }


    public List<Storehouse> getList() {
        return list;
    }
}