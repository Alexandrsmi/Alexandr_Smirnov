package ru.job4j;

	/**
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Turn {
	/**
	 * Метод переворачивающий массив.
	 * @param array - входящий массив.
	 * @return возвращаем обработанный массив.
	 */
    public int[] getBackArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp;
            temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
        return array;
    }
}