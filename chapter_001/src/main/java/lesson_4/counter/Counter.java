package lesson_4.counter;
	/**
	 * Класс вычисления суммы четных чисел  
	 * в заданном интервале.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Counter {
    private  long sum = 0;

    public Counter() {
        this.sum = sum;
    }
/**
	 * Метод вычисляющий сумму четных чисел.
	 * @start начальное значение интервала
	 * @finish конечное значени интервала
	 */
    public long add(long start, long finish) {
        long counter = start;
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