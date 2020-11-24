package com.company.java.concur.threadcom.innercon;

public class WaitInterruptTest {
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        System.out.println("线程1：中断状态为" + Thread.currentThread().isInterrupted());
                        System.out.println("线程1：进入等待状态");
                        this.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("线程2：中断线程1");
        thread.interrupt();
    }

    public static void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：中断自己");
                Thread.currentThread().interrupt();
                synchronized (this) {
                    try {
                        System.out.println("线程1：中断状态为" + Thread.currentThread().isInterrupted());
                        System.out.println("线程1：进入等待状态");
                        this.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
