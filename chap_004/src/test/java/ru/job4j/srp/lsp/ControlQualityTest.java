package ru.job4j.srp.lsp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.lsp.ControlQuality;
import ru.job4j.lsp.Storehouse;
import ru.job4j.lsp.Warehouse;
import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.food.Milk;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class ControlQualityTest {
    @Test
    public void addFoodOnStorehouse() {
        Food food = new Milk(new GregorianCalendar(2017, 3, 29));
        food.getExpiryDate();
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addFoodOnStorehouse(food);
        List<Storehouse> list = controlQuality.getList();
        Assert.assertTrue(list.size() > 0);
    }
}
