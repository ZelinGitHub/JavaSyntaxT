package com.company.java.classobject.implexten.implementchild;

//实现子接口
public class YellowBigApple implements BigApple {

    //实现父接口的方法
    @Override
    public void fk() {
        System.out.println("YellowBigApple fk");
    }

    //实现子接口的方法
    @Override
    public void sk() {
        System.out.println("YellowBigApple sk");
    }
}
