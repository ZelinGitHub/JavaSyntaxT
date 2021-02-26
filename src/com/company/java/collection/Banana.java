package com.company.java.collection;

public class Banana implements Comparable<Banana> {
    public int size;

    @Override
    public int compareTo(Banana pBanana) {
        return size - pBanana.size;
    }
}
