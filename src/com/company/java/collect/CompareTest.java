package com.company.java.collect;

import java.util.PriorityQueue;

public class CompareTest {
    public static void test1() {
        AppleComparator appleComparator = new AppleComparator();

        PriorityQueue<Apple> priorityQueue = new PriorityQueue<>(appleComparator);

    }

    public static void test2() {
        Banana banana1 = new Banana();
        banana1.size = 100;

        Banana banana2 = new Banana();
        banana2.size = 200;

        System.out.println(banana1.compareTo(banana2));

    }
}
