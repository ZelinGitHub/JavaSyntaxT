package com.company.java.classobject.member.constructor.fatherconstructor;

public class BlackBall extends Ball{
    private int mNumber;
    //自动调用父类默认的构造器
    public BlackBall(int pNumber){
        mNumber = pNumber;
    }
}
