package lesson_2.task_3;
	/**
	 * Класс содержащий математические 
	 * операции над числами.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Calculate {
	/**
	 * Поле сохранения результата.
	 */
    private double result;

    public Calculate() {
        this.result = result;
    }
	/**
	 * Метод получения суммы двух чисел.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 */
	 
    public void getSum(double first, double second) {
        this.result = first + second;
    }
	/**
	 * Метод получения разности двух чисел.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 */
	 
    public void getSub(double first, double second) {
        this.result = first - second;
    }
/**
	 * Метод получения частного двух чисел.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 */
    public void getDiv(double first, double second) {
        this.result = first / second;
    }
	/**
	 * Метод получения произведения двух чисел.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 */
	
    public void getMul(double first, double second) {
        this.result = first * second;
    }
	/**
	 * Метод получения значения поля result.
	 */
	 public double getResult() {
        return result;
    }
}
