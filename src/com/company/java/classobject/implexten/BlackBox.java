package com.company.java.classobject.implexten;

public class BlackBox extends Box {
    private int mNumber;

    public BlackBox() {
        super("abc");
    }

    public BlackBox(int pNumber) {
        this();
        mNumber = pNumber;
    }

}
