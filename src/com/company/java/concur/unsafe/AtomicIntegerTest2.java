package com.company.java.concur.unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {
    public static AtomicInteger sAtomicInteger = new AtomicInteger(0);

    public static void test() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sAtomicInteger.addAndGet(100);
                    sAtomicInteger.addAndGet(1);
                    System.out.println("线程" + Thread.currentThread().getId() + "：" + sAtomicInteger.get());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("线程" + Thread.currentThread().getId() + "：" + sAtomicInteger.get());
    }

    public static void test2() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    fuck();
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("线程" + Thread.currentThread().getId() + "：" + sAtomicInteger.get());
    }

    private static synchronized void fuck() {
        sAtomicInteger.addAndGet(100);
        sAtomicInteger.addAndGet(1);
        System.out.println("线程" + Thread.currentThread().getId() + "：" + sAtomicInteger.get());
    }
}
