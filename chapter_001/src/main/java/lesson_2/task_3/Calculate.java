package lesson_2.task_3;
	/**
	 * Класс содержащий математические 
	 * операции над числами.
	 */
public class Calculate {
	/**
	 * Поле для сохранения результата.
	 */
    private double result;

    public Calculate() {
        this.result = result;
    }
	/**
	 * Метод для получения суммы двух чисел.
	 *@first первый аргумент.
	 *@second второй аргумент.
	 */
	 
    public void getSum(double first, double second) {
        this.result = first + second;
    }
	/**
	 * Метод для получения разности двух чисел.
	 *@first первый аргумент.
	 *@second второй аргумент.
	 */
	 
    public void getSub(double first, double second) {
        this.result = first - second;
    }
/**
	 * Метод для получения частного двух чисел.
	 *@first первый аргумент.
	 *@second второй аргумент.
	 */
    public void getDiv(double first, double second) {
        this.result = first / second;
    }
	/**
	 * Метод для получения произведения двух чисел.
	 *@first первый аргумент.
	 *@second второй аргумент.
	 */
	
    public void getMul(double first, double second) {
        this.result = first * second;
    }
	/**
	 * Метод для получения значения поля result.
	 */
	 public double getResult() {
        return result;
    }
}
