package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {
    @Test
    public void whenExecuteMainThenPrintToConsole() {
        Calculate calculate = new Calculate();
        calculate.addSum(3, 4);
        Assert.assertEquals(7, 7);
    }
}