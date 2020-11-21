package com.company.java.concur.unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static AtomicInteger sAtomicInteger = new AtomicInteger(0);
    public static void test() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sAtomicInteger.incrementAndGet();
                    }
                    System.out.println(sAtomicInteger.get());
                }
            }).start();
        }


    }
}
