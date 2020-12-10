package com.company.java.concur.big3;

public class Big3SeeTest {
    private boolean mIsRunning = true;

    public void sink() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                while (mIsRunning) {
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
        System.out.println("线程:2：设置mIsRunning为false");
        mIsRunning = false;
    }

    public static void test() {
        Big3SeeTest big3SeeTest = new Big3SeeTest();
        big3SeeTest.sink();
    }
}
