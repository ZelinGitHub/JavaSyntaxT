package com.company.concur;

public class ThreadLocalTest {

    private static void testThreadLocal() {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("h");
        stringThreadLocal.get();
    }

}
