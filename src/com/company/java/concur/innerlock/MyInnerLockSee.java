package com.company.java.concur.innerlock;

public class MyInnerLockSee {
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

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                while (mIsRunning) {
                    synchronized (mLock) {
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

    public void kick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                synchronized (mLock) {
                    while (mIsRunning) {
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

    public void sick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:1：开始运行");
                synchronized (mLock) {
                    while (mIsRunning) {
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
        }
    }


    public static void test() {
        MyInnerLockSee myInnerLockSee = new MyInnerLockSee();
        myInnerLockSee.sink();
    }

    public static void test2() {
        MyInnerLockSee myInnerLockSee = new MyInnerLockSee();
        myInnerLockSee.fuck();
    }

    public static void test3() {
        MyInnerLockSee myInnerLockSee = new MyInnerLockSee();
        myInnerLockSee.kick();
    }

    public static void test4() {
        MyInnerLockSee myInnerLockSee = new MyInnerLockSee();
        myInnerLockSee.sick();
    }

}
