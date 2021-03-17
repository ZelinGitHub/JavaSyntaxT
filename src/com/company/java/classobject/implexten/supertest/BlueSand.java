package com.company.java.classobject.implexten.supertest;

public class BlueSand extends Sand {
    public void kick() {
        //引用父类变量
        String sandName = super.name;
        String sandColor=super.color;
        //调用父类方法
        super.fuck();
        super.kill();
    }
}
