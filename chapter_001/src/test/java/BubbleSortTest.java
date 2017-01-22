import lesson_5.BubblesSort;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тест пузырьковой сортировки
 */
public class BubblesSortTest {
	
   @Test
    public void getBubblesSortTest() {
		final int one = 1;
		final int two = 2;
		final int three = 3;
		final int four = 4;
		final int five = 5;
		final int six = 6;
		final int seven = 7;
		final int eight = 8;
		final int nine = 9;
		final int ten = 10;
		
		BubblesSort bubblesSort = new BubblesSort();
        int[] testArray = {one, three, five, seven, seven};
        int[] test = {one, five, seven, seven, three};
        int[] resultArray = bubblesSort.getBubbleSortArray(test);
        assertThat(testArray, is(resultArray));
    }
}