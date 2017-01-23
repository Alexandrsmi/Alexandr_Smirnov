package ru.job4j.factorial;

	/**
	 * Класс вычисления факториала числа.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Factorial {
	/**
	 * Метод вычисляющий факториал числа.
	 * @param fact - значение факториала.
	 * @return - возвращение факториала.
	 */
    public long getFactorial(long fact) {
        long counter = 1;
        long sum = 1;
        if (fact == 1) {
            return 1;
        }
        while (counter <= fact) {
            sum = sum * counter;
            counter++;
        }
        return sum;
    }
}