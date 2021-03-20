package com.company.java.classobject.implexten.FatherConstructor;

public class BlackBall extends Ball{
    private int mNumber;
    //自动调用父类默认的构造器
    public BlackBall(int pNumber){
        mNumber = pNumber;
    }
}
