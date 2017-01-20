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
        BubblesSort bubblesSort = new BubblesSort();
        int[] testArray = {1, 3, 5, 7, 7};
        int[] test = {1, 5, 7, 7, 3};
        int[] resultArray = bubblesSort.getBubbleSortArray(test);
        assertThat(testArray, is(resultArray));
    }
}