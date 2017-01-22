import org.junit.Assert;
import org.junit.Test;
import lesson_5.DeleteElementArray;

/**
 * Тест класса удаляющего дублирующиеся элементы массива.
 * @author smirnov
 * @since 22.01.2017
 */
public class DeleteElementsArrayTest {

	/**
	 * Тест метода присвающего дублирующим элементы массива null.
	 * Тест проверяет массив с нечетным количеством элеметнов.
	 */

    @Test
    public void allocNullToDuplicatingElementsDontEvenArrayTest() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {"4", "4", "3"};
        String[] arrayResultTest = {null, "4", "3"};
        String[] result = deleteElementArray.allocNullToDuplicatingElements(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

	/**
	 * Тест метода переносящего null элементы в конец массива.
	 * Тест проверяет массив с нечетным количеством элеметнов.
	 */
	 
    @Test
    public void sortNullTheElementsDontEvenArrayTest() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {null, "4", "3"};
        String[] arrayResultTest = {"3", "4", null};
        String[] result = deleteElementArray.sortNullTheElementsArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }
	
	/**
	 * Тест метода удаляющего null элементы массива.
	 * Тест проверяет массив с нечетным количеством элеметнов.
	 */

    @Test
    public void deletionNullInArrayDontEvenArray() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {"3","4",null};
        String[] arrayResultTest = {"3","4"};
        String[] result = deleteElementArray.deletionNullInArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }
	
	/**
	 * Тест метода присвающего дублирующим элементы массива null.
	 * Тест проверяет массив с четным количеством элеметнов.
	 */
	 
    @Test
    public void allocNullToDuplicatingElementsEvenArrayTest() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {"4", "4", "3","5"};
        String[] arrayResultTest = {null, "4", "3","5"};
        String[] result = deleteElementArray.allocNullToDuplicatingElements(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }
	
	/**
	 * Тест метода переносящего null элементы в конец массива.
	 * Тест проверяет массив с не четным количеством элеметнов.
	 */

    @Test
    public void sortNullTheElementsDontArrayTest() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {null, "4", "3","5"};
        String[] arrayResultTest = {"5", "4","3", null};
        String[] result = deleteElementArray.sortNullTheElementsArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

	/**
	 * Тест метода удаляющего null элементы массива.
	 * Тест проверяет массив с не четным количеством элеметнов.
	 */
	 
    @Test
    public void deletionNullInArrayEvenArray() {
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {"5","3","4",null};
        String[] arrayResultTest = {"5","3","4"};
        String[] result = deleteElementArray.deletionNullInArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }
}
