package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Tracker;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 04.02.2017.
 */
public class TrackerTest {

    @Test
    public void addItemTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item", "descr");
        Item result = tracker.getAddItem(item);
        assertThat(item, is(result));
    }

    //    @Test
//    public void editTest() {
//        Tracker tracker = new Tracker();
//
//        Item item = new Item("item", "d");
//
//        tracker.getAddItem(item);
//
//        Task task = new Task("test","test");
//        task.setId(item.getId());
//        tracker.edit(task);
//asser(item.equals(task));
//    }
    @Test
    public void findByIdTest() {
        Item item = new Item("name", "desc");
        Item item11 = new Item("name1", "desc1");
        Tracker tracker = new Tracker();
        tracker.getAddItem(item);
        tracker.getAddItem(item11);
        Item result = tracker.findById(item.getId());
        assertThat(item, is(result));
    }

    @Test
    public void findByNameTest() {
        Item item = new Item("name", "desc");
        Item item11 = new Item("name1", "desc1");
        Tracker tracker = new Tracker();
        tracker.getAddItem(item);
        tracker.getAddItem(item11);
        Item result = tracker.findByName(item.getName());
        assertThat(item, is(result));
    }

    @Test
    public void createCommentTest() {
        Item item = new Item("name", "desc");
        Tracker tracker = new Tracker();
        tracker.getAddItem(item);
        tracker.createComment(item.getId(), "test");
        String result = "test";
        assertThat(item.getComment(), is(result));
    }

    @Test
    public void getAllTest() {
        Item item = new Item("name", "desc");
        Item item1 = new Item("name1", "desc1");
        Tracker tracker = new Tracker();
        tracker.getAddItem(item);
        tracker.getAddItem(item1);
        Item[] items = tracker.getAll();
        boolean result = items.length > 0;
        assertTrue(result);
    }

    @Test
    public void DeleteById() {
        Item item2 = new Item("name", "desc");
        Item item1 = new Item("name1", "desc1");
        Tracker tracker = new Tracker();
        tracker.getAddItem(item1);

           tracker.getAddItem(item1);

        tracker.deleteItem(tracker.findById(item2.getId()));
        System.out.println(String.format("%s",item2));
        assertTrue(item2==null);

    }
}