package com.company.java.generic;

public class Photo<T> {
    public void setImg(T pT) {
        System.out.println("Photo" + pT.toString());
    }
}