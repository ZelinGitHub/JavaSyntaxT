package com.company.java.concur.threadcom.innercon;

public class WaitNotifyConSpinTest3 {
    private boolean mPrevIsA = false;
    private final String mLock = "ABC";

    private void start() {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    printA();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    printB();
                }
            }).start();
        }
    }

    private void printA() {
        synchronized (mLock) {
            while (mPrevIsA) {
                try {
                    mLock.wait();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
            System.out.println("AAAAAAAAAA");
            mPrevIsA = true;
            mLock.notifyAll();
        }
    }

    private void printB() {
        synchronized (mLock) {
            while (!mPrevIsA) {
                try {
                    mLock.wait();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
            System.out.println("BBBBBBBBBB");
            mPrevIsA = false;
            mLock.notifyAll();
        }
    }

    public static void test() {
        WaitNotifyConSpinTest3 waitNotifyConSpinTest3 = new WaitNotifyConSpinTest3();
        waitNotifyConSpinTest3.start();
    }
}
