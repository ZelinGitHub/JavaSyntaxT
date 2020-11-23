package com.company.java.concur.threadcom.innercon;

public class InnerConTest2 {
    private boolean mIsNotReceive = true;
    private final String mLock = "abc";

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：开始执行");
                while (mIsNotReceive) {
                    synchronized (mLock) {
                        try {
                            mLock.wait();
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                    }
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
                    synchronized (mLock) {
                        mLock.notifyAll();
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }

    public static void test() {
        InnerConTest2 innerConTest22 = new InnerConTest2();
        innerConTest22.fuck();
    }
}
