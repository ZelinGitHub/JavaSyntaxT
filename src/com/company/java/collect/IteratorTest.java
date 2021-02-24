package com.company.java.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public void fuck() {
        List<Apple> list = new ArrayList<>();
        Iterator<Apple> iterator = list.iterator();
        iterator.next();
        iterator.hasNext();
        iterator.remove();
    }

    public void kick() {
        List<String> list = new ArrayList<>();
        list.add("Hitler");
        list.add("Mike");
        list.add("Sara");
        list.add("Linda");
        list.add("Jinx");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }

    public void lick() {
        List<Apple> list2 = new LinkedList<>();
        Iterator<Apple> iterator1 = list2.listIterator();
    }

    public static void test() {
        IteratorTest iteratorTest = new IteratorTest();
        iteratorTest.kick();
    }
}
