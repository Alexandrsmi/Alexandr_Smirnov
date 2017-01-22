import lesson_5.TurnArray;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тест переворачивания квадратного массива на 90 градусов.
 */
public class TurnArrayTest {
    
	@Test
    public void getTurnArray(){
        TurnArray turnArray = new TurnArray();
        int[][] array = {{1,2},{3,4}};
        int[][] arrayResult = {{3,1},{4,2}};
        int[][] arrayTest = turnArray.getTurnArray(array);
        Assert.assertArrayEquals(arrayTest,arrayResult);
    }
}