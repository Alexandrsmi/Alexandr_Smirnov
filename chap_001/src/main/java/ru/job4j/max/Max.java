package ru.job4j.max;

	/**
	 * Класс для определения наибольшего числа.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Max {
	/**
	 * Метод нахождения наибольшего числа из двух.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 * @return - возвращает максимальное число.
	 */
    public int max(int first, int second) {
       return first > second ? first : second;
    }
	/**
	 * Метод нахождения наибольшего числа из трех.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 * @param third - третий аргумент.
	 * @return - возращает максимальное число.
	 */
    public int max(int first, int second, int third) {
        int temp = max(first, second);
        int max = temp > third ? temp : third;
    return max;
    }
}