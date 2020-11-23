package com.company.java.concur.threadcom;

public class SimpleSpinTest {
    private volatile boolean mIsNotReceive = true;

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：开始执行");
                while (mIsNotReceive) {
                }
                System.out.println("线程1：我退出了");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2：开始执行");
                try {
                    Thread.sleep(5000);
                    System.out.println("线程2：退出线程1");
                    mIsNotReceive = false;
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
    public static void test() {
        SimpleSpinTest simpleSpinTest = new SimpleSpinTest();
        simpleSpinTest.fuck();
    }
}
