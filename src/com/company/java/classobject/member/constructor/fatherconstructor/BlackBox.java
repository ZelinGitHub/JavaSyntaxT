package com.company.java.classobject.member.constructor.fatherconstructor;

public class BlackBox extends Box {
    private int mNumber;

    public BlackBox() {
        //显式调用父类构造方法
        super("abc");
        int i=0;
    }






    public BlackBox(int pNumber) {
        //通过调用其他构造方法，间接调用父类构造方法
        this();
        mNumber = pNumber;
    }

}
