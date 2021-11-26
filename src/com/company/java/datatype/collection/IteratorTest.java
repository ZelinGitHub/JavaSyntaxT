package com.company.java.datatype.collection;

import java.util.*;

public class IteratorTest {
    public void fuck() {
        List<Apple> list = new ArrayList<>();
        Iterator<Apple> iterator = list.iterator();
        iterator.next();
        iterator.hasNext();
        iterator.remove();
    }


    public void lick() {
        List<String> list = new LinkedList<String>();
        ListIterator<String> listIterator = list.listIterator();
        //添加元素后，列表迭代器也会移动到刚添加的元素位置
        listIterator.add("madagascar");
        listIterator.add("galapagos");
        listIterator.add("komodo");
        for (String str:list){
            System.out.println(str);
        }
    }

    public void traversalListByIterator() {
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

    public void traversalListByStringFor() {
        List<String> list = new ArrayList<>();
        list.add("Hitler");
        list.add("Mike");
        list.add("Sara");
        list.add("Linda");
        list.add("Jinx");
        for (String name : list) {
            System.out.println(name);
        }
    }


    public static void test() {
        IteratorTest iteratorTest = new IteratorTest();
        iteratorTest.lick();
    }
}
