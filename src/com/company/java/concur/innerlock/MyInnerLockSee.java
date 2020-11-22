package com.company.java.concur.innerlock;

public class MyInnerLockSee {
    private boolean mIsRunning = true;

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                while (mIsRunning) {
                    synchronized (this){
                    }
                }
                System.out.println("线程:1：停止运行");
            }
        }).start();
    }

    public static void test() {
        MyInnerLockSee myInnerLockSee = new MyInnerLockSee();
        myInnerLockSee.fuck();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("线程:2：设置mIsRunning为false");
        myInnerLockSee.mIsRunning = false;
    }
}
