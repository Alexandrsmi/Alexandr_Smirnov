package lesson_5;
	/**
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Turn {
    
	/**
	 * Метод переворачивающий массив.
	 * @int[] array входящий массив.
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