package ru.job4j;

/**
 * Class объединяющий два отсортированных массива.
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 05.02.2017.
 */
public class TwoArraySort {
    /**
     * Метод объединяющий два отсортированных массива.
     * @param array - first array
     * @param arrayTwo - second array
     * @return arr - iterated array
     */
    public int[] sortTwoArrays(int[] array, int[] arrayTwo) {
        int[] arr = new int[6];
        for (int b = 0; b < arr.length; ) {
            for (int i = 0; i < array.length; ) {
                for (int j = 0; j < arrayTwo.length; ) {
                    if (i<array.length&&array[i] < arrayTwo[j]) {
                        arr[b] = array[i];
                        b++;
                        i++;
                    } else {
                        arr[b] = arrayTwo[j];
                        b++;
                        j++;
                    }
                }
            }
        }
        return arr;
    }
}