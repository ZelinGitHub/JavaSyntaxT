package com.company.java.concur.big3;

public class Big3SeeYieldTest {
    private boolean mIsRunning = true;

    public void suck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                while (mIsRunning) {
                    System.out.println("线程:1：开始让步，mIsRunning值为" + mIsRunning);
                    Thread.yield();
                    System.out.println("线程:1：让步结束，mIsRunning值为" + mIsRunning);
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
        Big3SeeYieldTest big3BlockWakeSeeTest = new Big3SeeYieldTest();
        big3BlockWakeSeeTest.suck();
    }
}
