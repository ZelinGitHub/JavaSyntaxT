package com.company.java.classobject.implexten.supertest;

public class Sand {
    //实例域
    protected String name = "Tom";
    //常量实例域
    protected final String color = "red";
    //静态域
    public static String size = "large";

    //实例方法
    protected void fuck() {
        System.out.println("Sand fuck");
    }

    //final实例方法
    protected final void kill() {
        System.out.println("Sand kill");
    }

    //静态方法
    public static void lick() {
        System.out.println("Sand lick");
    }
}
