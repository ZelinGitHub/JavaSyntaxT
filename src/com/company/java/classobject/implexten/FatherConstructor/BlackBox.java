package com.company.java.classobject.implexten.FatherConstructor;

public class BlackBox extends Box {
    private int mNumber;

    public BlackBox() {
        //显式调用父类构造方法
        super("abc");
    }

    public BlackBox(int pNumber) {
        //通过调用其他构造方法，间接调用父类构造方法
        this();
        mNumber = pNumber;
    }

}
