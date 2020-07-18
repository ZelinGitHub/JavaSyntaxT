package com.company.collect;

import java.util.*;

public class CollectionTest {

    private static void testCollection() {
        Collection<String> collection;
        Queue<String> queue;
        Set<String> set = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        PriorityQueue<String> priorityQueue;

        Deque<String> deque = new LinkedList<>();
        List<String> list = new LinkedList<>();
        List<String> list2 = new ArrayList<>();
        list.remove(0);
        Iterator<String> iterator = list.iterator();
        Iterator<String> iterator2 = deque.iterator();
        Iterator<String> iterator1 = list.listIterator();

        ArrayDeque arrayDeque;
    }

}
