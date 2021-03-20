package com.company.java.classobject.enumeration;

public class EnumTest {
    public void fuckEnum() {
        //引用枚举常量
        Status status = Status.CONFIRMED;
        //每个枚举类都隐式定义了一个静态的values 方法
        //得到包含全部枚举常量的数组。
        Status[] statuses = Status.values();
    }
}
