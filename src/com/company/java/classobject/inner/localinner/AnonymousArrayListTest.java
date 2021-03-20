package com.company.java.classobject.inner.localinner;

import java.util.ArrayList;

public class AnonymousArrayListTest {
    public void generateAnonymousArrayList() {
        //外层括号建立了ArrayList 的一个匿名子类对象
        //内层括号是一个初始化块
        new ArrayList<String>() {
            {
                add("Harry");
                add("Tony");
            }
        };
    }
}
