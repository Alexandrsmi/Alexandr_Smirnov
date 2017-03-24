package ru.job4j;

import java.awt.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    private long addTimeArrayList = 0;
    private long addTimeLinkedList = 0;
    private long addTimeTreeSet = 0;
    private long deleteTimeArrayList = 0;
    private long deleteTimeLinkedList = 0;
    private long deleteTimeTreeSet = 0;

    public App() {
        this.addTimeArrayList = addTimeArrayList;
        this.addTimeLinkedList = addTimeLinkedList;
        this.addTimeTreeSet = addTimeTreeSet;
        this.deleteTimeArrayList =  deleteTimeArrayList;
        this.deleteTimeLinkedList = deleteTimeLinkedList;
        this.deleteTimeTreeSet = deleteTimeTreeSet;
    }

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Collection<String> collList = new LinkedList<>();
        Collection<String> collSet = new TreeSet<>();
        App app = new App();
        String symbols = "qwerty";
        StringBuilder randString = new StringBuilder();
        int addCount = (int) (Math.random() * 10000) + 1000;
        int count = (int) (Math.random() * 30);
        String s = null;

        for (int j = 0; j < addCount; j++) {
            for (int i = 0; i < count; i++) {
                randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
                s = String.valueOf(randString);
            }
            app.addTimeArrayList = app.add(collection, s) + app.addTimeArrayList;
            app.addTimeLinkedList = app.add(collList, s) + app.addTimeLinkedList;
            app.addTimeTreeSet = app.add(collSet, s) + app.addTimeTreeSet;
            app.deleteTimeArrayList = app.delete(collection, s,100) + app.deleteTimeArrayList;
            app.deleteTimeLinkedList = app.delete(collList, s,100) + app.deleteTimeLinkedList;
            app.deleteTimeTreeSet = app.delete(collSet, s,100) + app.deleteTimeTreeSet;
        }

        System.out.println("Кол-во слов - " + addCount);
        System.out.println(app.addTimeArrayList);
        System.out.println(app.addTimeLinkedList);
        System.out.println(app.addTimeTreeSet);

        System.out.println( app.deleteTimeArrayList);
        System.out.println( app.deleteTimeLinkedList);
        System.out.println( app.deleteTimeTreeSet);
    }

    public long add(Collection<String> collection, String line) {
        long start = System.nanoTime();
        collection.add(line);
        long finish = System.nanoTime();
        long result = (finish - start);
        return result;
    }

    public long delete(Collection<String> collection, String line, int amount) {
        int i = 0;
        long start;
        long finish;
        long result = 0;
        for (; i <= amount; i++) {
            start = System.nanoTime();
            collection.remove(i);
            finish = System.nanoTime();
            result = (finish - start);
        }
        return result;
    }
}
