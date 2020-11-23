package com.company.java.concur.threadcom;

public class InnerConTest {
    private final String mLock = "abc";

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mLock) {
                    System.out.println("线程1：我阻塞了");
                    try {
                        mLock.wait();
                        System.out.println("线程1：我醒来了");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                        System.out.println("线程1：我醒来了");
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mLock) {
                        System.out.println("线程2：我要唤醒线程1");
                        mLock.notifyAll();
                }
            }
        }).start();
    }
    public static void test() {
        InnerConTest innerConTest = new InnerConTest();
        innerConTest.fuck();
    }
}
