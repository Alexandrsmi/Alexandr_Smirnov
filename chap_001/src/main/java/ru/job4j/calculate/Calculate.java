package ru.job4j.calculate;

	/**
	 * Класс содержащий математические операции над числами.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Calculate {
	/**
	 * @param result - хранения результата.
	 */
    private double result;
	/**
	 * Метод получения суммы двух чисел.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
    public void getSum(double first, double second) {
        this.result = first + second;
    }
	/**
	 * Метод получения разности двух чисел.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
    public void getSub(double first, double second) {
        this.result = first - second;
    }
	/**
	 * Метод получения частного двух чисел.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
    public void getDiv(double first, double second) {
        this.result = first / second;
    }
	/**
	 * Метод получения произведения двух чисел.
	 * @param first первый аргумент.
	 * @param second второй аргумент.
	 */
    public void getMul(double first, double second) {
        this.result = first * second;
    }
	/**
	 * Метод получения значения поля result.
	 * @return - получения значения result.
	 */
	 public double getResult() {
        return result;
    }
}