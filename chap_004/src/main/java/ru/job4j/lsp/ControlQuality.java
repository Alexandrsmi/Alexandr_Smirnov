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
//
    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Milk(new GregorianCalendar(2017, 3, 7));
        Food food2 = new Milk(new GregorianCalendar(2017, 2, 28));
        Food food3 = new Milk(new GregorianCalendar(2017, 3, 4));
        Food food1 = new Curd(new GregorianCalendar(2017,3,6));
        food1.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food1);
        food2.getExpiryDate();
        food.getExpiryDate();
        food3.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food3);
        controlQuality.addFoodOnStorehouse(food);
        controlQuality.addFoodOnStorehouse(food2);
        food.setCreateDate(new GregorianCalendar(2017,3,9));
        food.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food);
        food.setCreateDate(new GregorianCalendar(2017,3,1));
        food.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food);
        food.setCreateDate(new GregorianCalendar(2017,2,3));
        food.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food);
        for (Storehouse storeg : storegs) {
            System.out.println(storeg);
        }
    }

    public List<Storehouse> getList() {
        return list;
    }
}