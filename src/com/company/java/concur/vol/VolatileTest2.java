package com.company.java.concur.vol;

public class VolatileTest2 {
    private volatile boolean mIsRunning = true;

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：开始运行，mIsRunning为" + mIsRunning);
                while (mIsRunning) {
                }
                System.out.println("线程1：运行结束，mIsRunning为" + mIsRunning);
            }
        }).start();
    }

    public static void test() {
        VolatileTest2 volatileTest = new VolatileTest2();
        volatileTest.fuck();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        volatileTest.mIsRunning = false;
        System.out.println("线程2：设置mIsRunning为false");
    }
}
