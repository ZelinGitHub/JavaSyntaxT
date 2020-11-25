package com.company.java.concur;

import com.company.java.concur.innerlock.MyInnerLockSee;

public class BlockWakeSeeTest {
    private boolean mIsRunning = true;

    private final String mLock = "abc";

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
        BlockWakeSeeTest blockWakeSeeTest = new BlockWakeSeeTest();
        blockWakeSeeTest.sink();
    }

    public static void test2() {
        BlockWakeSeeTest blockWakeSeeTest = new BlockWakeSeeTest();
        blockWakeSeeTest.dick();
    }

    public static void test3() {
        BlockWakeSeeTest blockWakeSeeTest = new BlockWakeSeeTest();
        blockWakeSeeTest.suck();
    }
}
