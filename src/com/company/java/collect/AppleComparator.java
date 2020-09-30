package com.company.java.collect;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple pApple1, Apple pApple2) {
        return pApple1.size - pApple2.size;
    }
}
