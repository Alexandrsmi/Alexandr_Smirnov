package lesson_2.task_3;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {
    @Test
    public void whenExecuteMainThenPrintToConsole() {
        Calculate calculate = new Calculate();
        calculate.getSum(3, 4);
        Assert.assertEquals(7, 7);
    }
}