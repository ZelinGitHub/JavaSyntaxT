package com.company.java.collect;

import java.util.*;

public class ListTest {

    private void fuck() {
        List<String> list = new ArrayList<String>();
        ListIterator<String> listIterator = list.listIterator();
        ListIterator<String> listIterator1 = list.listIterator(3);

        Iterator<String> iterator = list.iterator();

        List<String> subList = list.subList(1, 5);
    }

    private void suck() {
        //作为List使用
        List<String> list = new LinkedList<>();
        //作为Deque使用
        Deque<Integer> deque = new LinkedList<>();
    }
}
