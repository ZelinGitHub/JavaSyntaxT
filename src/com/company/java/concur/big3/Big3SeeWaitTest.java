package com.company.java.concur.big3;

public class Big3SeeWaitTest {
    private boolean mIsRunning = true;

    private final String mLock = "abc";


    public void dick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                synchronized (mLock) {
                    while (mIsRunning) {
                        try {
                            System.out.println("线程:1：开始阻塞，mIsRunning值为" + mIsRunning);
                            mLock.wait();
                            System.out.println("线程:1：解除阻塞，mIsRunning值为" + mIsRunning);
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                    }
                }
                System.out.println("线程:1：停止运行");
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        synchronized (mLock) {
            System.out.println("线程:2：设置mIsRunning为false");
            mIsRunning = false;
            mLock.notifyAll();
        }
    }

    public static void test() {
        Big3SeeWaitTest big3SeeWaitTest = new Big3SeeWaitTest();
        big3SeeWaitTest.dick();
    }

}
