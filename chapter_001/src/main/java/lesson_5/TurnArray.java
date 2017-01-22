package lesson_5;

/**
 * Класс для переворачивания квадратного массива на 90 градусов.
 */ 
 
public class TurnArray {
/**
 * Метод переворачивющий квадратный массив на 90 градусов.
 */
 
    public void getTurnArray(int[][] array) {
        int[][] reverseArray = new int[array.length][array.length];
        for (int i = 0; i < reverseArray.length; i++) {
            for (int j = 0; j < reverseArray.length; j++) {
                reverseArray[j][reverseArray.length - 1 - i] = array[i][j];
            }
        }
    }
}