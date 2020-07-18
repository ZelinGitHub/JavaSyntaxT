package com.company.generic;

public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T pFirst, T pSecond) {
        first = pFirst;
        second = pSecond;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T pFirst) {
        first = pFirst;
    }

    public void setSecond(T pSecond) {
        second = pSecond;
    }

    public void dig() {
        T t;
    }
}
