package ru.job4j.start;

import ru.job4j.models.*;

import java.util.*;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 25.01.2017.
 */
public class Tracker {
    /**
     * items - массив хранящий все объекты Item.
     */
    private Item[] items = new Item[100];
    /**
     * position - позиция элемента в массиве.
     */
    private int position = 0;
    /*
     * rN - случайное число для id объекта.
     */
    private static final Random rN = new Random();

    /**
     * Метод добавления элемента в массив объекта.
     *
     * @param item - входящий объект массива.
     * @return item - добавленный объект.
     */
    public Item getAddItem(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        Date date = new Date();
        item.setDateCreateItem(date);
        return item;
    }

    /**
     * Метод изменнения полей элемента по id.
     *
     * @param fresh
     */
    public void edit(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }
    }

    /**
     * Метод поиска объекта по полю id.
     *
     * @param id - entering id object.
     * @return result - finding object.
     */
    public Item findById(String id) {
        Item result;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                return result;
            }
        }
        return null;
    }

    /**
     * Метод поска объекта по полю name.
     *
     * @param name - entering name.
     * @return result - finding object.
     */
    public Item findByName(String name) {
        Item result;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                return result;
            }
        }
        return null;
    }

    /**
     * Метод добавляющий комментарий к объекту.
     *
     * @param id      - entering id object.
     * @param comment - entering comment.
     */
    public void createComment(String id, String comment) {
        for (Item it : items) {
            if (it != null && it.getId().equals(id)) {
                it.setComment(comment);
            }
        }
    }

    /**
     * Медот генерации случайного числа.
     *
     * @return - случайное число String.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + rN.nextInt());
    }

    /**
     * Метод для поиска всех объектов .
     *
     * @return - возвращает массив объектов.
     */
    public Item[] getAll() {
        Item[] resault = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            resault[index] = this.items[index];
        }
        return resault;
    }

    /**
     * Метод присваивает значение null  найденному объекту.
     *
     * @param item - entering object.
     * @return items - iterated array Item.
     */
    public Item[] deleteItem(Item item) {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = null;
                break;
            }
        }
        return items;
    }

    /**
     * Метод переносит null объект в конец массива.
     *
     * @return items - iterated array.
     */
    public Item[] sortNullTheElementsArray() {
        int count = 0;
        for (int i = position; i < count; ) {
            if (items[count] == null) {
                Item temp;
                temp = items[i];
                items[i] = items[count];
                items[count] = temp;
                i--;
            }
            count++;
        }
        return items;
    }
}

