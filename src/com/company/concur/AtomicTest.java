package com.company.concur;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger sAtomicInteger = new AtomicInteger(0);
    public static CountDownLatch sCountDownLatch = new CountDownLatch(2);

    public static void test() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sAtomicInteger.incrementAndGet();
                    }
                    sCountDownLatch.countDown();
                }
            }).start();
        }
        try {
            sCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(sAtomicInteger.get());
    }


}
