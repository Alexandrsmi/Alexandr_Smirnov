package ru.job4j.calculate;

	/**
	 * Класс содержащий математические операции над числами.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Calculate {
	/**
	 * @param result - keeping result.
	 */
    private double result;
	/**
	 * The method of sum of two numbers
	 * @param first first argument.
	 * @param second second argument.
	 */
    public void getSum(double first, double second) {
        this.result = first + second;
    }
	/**
	 * The method of subtraction of two numbers.
	 * @param first first argument.
	 * @param second second argument.
	 */
    public void getSub(double first, double second) {
        this.result = first - second;
    }
	/**
	 *The method of division of two numbers.
	 * @param first first argument.
	 * @param second second argument.
	 */
    public void getDiv(double first, double second) {
        this.result = first / second;
    }
	/**
	 * The method of multiplication of two numbers.
	 * @param first first argument.
	 * @param second second argument.
	 */
    public void getMul(double first, double second) {
        this.result = first * second;
    }
	/**
	 * The method of getting the value of the "result" variable.
	 * @return - of getting the value og the "result" variable.
	 */
	 public double getResult() {
        return result;
    }
}