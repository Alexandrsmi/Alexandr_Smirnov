package lesson_3.max;
	/**
	 * Класс содержащий математические 
	 * операции над числами.
	 * @author smirnov
	 * @since 21.01.2017
	 */
	 
public class Max {
	/**
	 * Метод нахождения наибольшего числа из двух.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 */
    public int max(int first, int second){
       return first > second ? first : second;  
    }
	/**
	 * Метод нахождения наибольшего числа из трех.
	 * @first первый аргумент.
	 * @second второй аргумент.
	 * @thrid третий аргумент.
	 */
	 
    public int max(int first, int second, int third) {
        int temp = max(first, second);
        int max = temp > third ? temp : third;
    return max;
    }
}