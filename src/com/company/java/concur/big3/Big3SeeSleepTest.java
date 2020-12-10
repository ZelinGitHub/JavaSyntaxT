package com.company.java.concur.big3;

public class Big3SeeSleepTest {
    private boolean mIsRunning = true;

    public void suck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                while (mIsRunning) {
                    try {
                        System.out.println("线程:1：开始阻塞，mIsRunning值为" + mIsRunning);
                        Thread.sleep(5000);
                        System.out.println("线程:1：解除阻塞，mIsRunning值为" + mIsRunning);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
                System.out.println("线程:1：停止运行");
            }
        }).start();
        System.out.println("线程:2：设置mIsRunning为false");
        mIsRunning = false;
    }

    public static void test() {
        Big3SeeSleepTest big3BlockWakeSeeTest = new Big3SeeSleepTest();
        big3BlockWakeSeeTest.suck();
    }
}
