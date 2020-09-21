package com.company.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public static void test(){
        List<Apple> list=new ArrayList<>();
        Iterator<Apple> iterator = list.iterator();


        iterator.next();
        iterator.hasNext();
        iterator.remove();

        List<Apple> list2=new LinkedList<>();
        Iterator<Apple> iterator1 = list2.listIterator();
    }
}
