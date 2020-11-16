package com.company.java.concur.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static final CountDownLatch sLatchGate = new CountDownLatch(1);

    private static final CountDownLatch sLatch = new CountDownLatch(3);


    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程：" + Thread.currentThread().getId() + "，准备数据");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程：" + Thread.currentThread().getId() + "，数据准备结束");
                sLatchGate.countDown();
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sLatchGate.await();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("线程：" + Thread.currentThread().getId() + "，使用数据");
                }
            }).start();
        }
    }

    public static void test2() {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程：" + Thread.currentThread().getId() + "，开始运行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("线程：" + Thread.currentThread().getId() + "，运行结束");
                    sLatch.countDown();
                }
            }).start();
        }
        try {
            sLatch.await();
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("线程：" + Thread.currentThread().getId() + "，所有工作线程执行结束");
    }
}
