package com.company.java.concur.threadcom.innercon;

public class NotifyNotAutoUnlockTest {
    public static void test() {
        String mLock = "abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mLock) {
                    System.out.println("线程1：开始等待");
                    try {
                        mLock.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("线程1：结束等待");
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (mLock) {
                    System.out.println("线程2：唤醒线程1");
                    mLock.notifyAll();
                    try {
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                            System.out.println("线程2：正在运行");
                        }
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
