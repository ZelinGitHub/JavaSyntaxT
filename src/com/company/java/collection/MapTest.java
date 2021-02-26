package com.company.java.collection;

import java.util.*;

public class MapTest {
    public void fuck() {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new TreeMap<>();
    }

    public void getWeakHashSet() {
        Map<Object, Boolean> map = new WeakHashMap<>();
        Set<Object> weakHashSet = Collections.newSetFromMap(map);
    }
}
