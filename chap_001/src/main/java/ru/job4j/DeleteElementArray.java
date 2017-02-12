package ru.job4j;
import java.util.Arrays;

	/**
	* Класс удаляющий дубликаты из массива массива.
	* @author smirnov
	* @since 22.01.2017
	*/
public class DeleteElementArray {
	/**
	* Метод присваивает дублирующимся элементам - null.
	* @param strings - входящий массив строк.
	* @return strings - возвращение обработанного массива.
	*/
    public String[] allocNullToDuplicatingElements(String[] strings) {
        for (int i = strings.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strings[i] == strings[j]) {
                    strings[j] = null;
                }
            }
        }
        return strings;
    }
	/**
	* Метод переносит null элементы в конец массива.
	* @param strings - входящий массив.
	* @return strings - возврат обработанного массива.
	*/
    public String[] sortNullTheElementsArray(String[] strings) {
        int count = 0;
        for (int i = strings.length - 1; i >= count;) {
            if (strings[count] == null) {
                String tem;
                tem = strings[i];
                strings[i] = strings[count];
                strings[count] = tem;
                i--;
            }
            count++;
        }
        return strings;
    }
	/**
	* Метод удаляет null значение из массива.
	* @param strings - входящий массив.
	* @return arrayCopy - возврат обработанного массива.
	*/
    public String[] deletionNullInArray(String[] strings) {
        int countNull = 0;
        for (String ar : strings) {
            if (ar == null) {
                countNull++;
            }
        }
        String[] arrayCopy = Arrays.copyOf(strings, (strings.length) - countNull);
        return arrayCopy;
    }
}