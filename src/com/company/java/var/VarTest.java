package com.company.java.var;

public class VarTest {
    //初始化指针为null
    private String mTail = null;

    public void test() {
        //使用指针mTail的值，初始化指针t的值
        String t = mTail;
        //使指针mTail指向另一个对象
        mTail="ABC";

        System.out.println("t："+t);
        System.out.println("mTail："+mTail);
    }
}
