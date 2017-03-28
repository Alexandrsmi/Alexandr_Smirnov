package ru.job4j.convert;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class ConvertArrayList {
    /**
     * Метод получения лист из массива.
     *
     * @param array
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;

    }

    /**
     * Метод получение массива из List.
     *
     * @param list - коллекция.
     * @param rows - кол-во размер массива.
     * @return - массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int temp = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (temp < list.size()) {
                    array[i][j] = list.get(temp);
                    temp++;
                } else {
                    return array;
                }
            }
        }
        return array;
    }

    /**
     * Метод вычисляет rows.
     *
     * @param list - входящий список.
     * @return rows - кол-во колонок.
     */

    public int getRows(List<Integer> list) {
        int rows = list.size();
        do {
            if (Math.sqrt(rows) % 1 == 0) {
                return (int) Math.sqrt(rows);
            }
            rows++;
        } while (rows % 1 == 0);
        return 0;
    }

    /**
     * Метод переносит данные из List<int[]> в List<Integer>.
     * @param list
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] array = list.get(i);
            for (Integer j:array) {
                result.add(j);
            }
        }
        return result;
    }
}