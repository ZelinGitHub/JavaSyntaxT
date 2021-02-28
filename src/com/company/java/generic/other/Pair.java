package com.company.java.generic.other;

//定义泛型类
public class Pair<T> {
    private T first;
    private T second;

    public T mDick;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirstO() {
        return first;
    }

    public T getSecondO() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}