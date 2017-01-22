import lesson_5.Turn;
import org.junit.*;
/**
 * Тест переворота массива
 */
public class TurnTest {
   
   @Test
    public void getBackArrayTest() {
        Turn turn = new Turn();
        int[] mass = {3, 2, 1};
        int[] array = {1, 2, 3};
        int[] result = turn.getBackArray(array);
        Assert.assertArrayEquals(mass, result);
    }
}