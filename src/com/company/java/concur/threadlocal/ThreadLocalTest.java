package com.company.java.concur.threadlocal;

public class ThreadLocalTest {

    public static void test() {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        System.out.println(stringThreadLocal.get());
        stringThreadLocal.set("fuck u");
        System.out.println(stringThreadLocal.get());
    }

}
