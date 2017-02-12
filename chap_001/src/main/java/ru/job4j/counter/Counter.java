package ru.job4j.counter;

	/**
	 * Класс вычисления суммы четных чисел в заданном интервале.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Counter {
	/**
	 * Метод вычисляющий сумму четных чисел.
	 * @param start - начальное значение интервала.
	 * @param finish - конечное значени интервала.
	 * @return sum - возвращение суммы чисел в заданном интервале.
	 */
    public long add(long start, long finish) {
        long counter = start;
		long sum = 0;
        while (counter <= finish) {
            if (counter % 2 == 0) {
                sum = sum + counter;
                counter++;
            } else {
                counter++;
            }
        }
        return sum;
    }
}