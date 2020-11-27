package com.company.java.concur.threadcom.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProConCrossTest {
    private boolean mPrevIsA = false;
    private final Lock mLock = new ReentrantLock();

    private final Condition mConditionA = mLock.newCondition();
    private final Condition mConditionB = mLock.newCondition();

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
        mLock.lock();
        try {
            while (mPrevIsA) {
                try {
                    mConditionA.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
            System.out.println("AAAAAAAAAA");
            mPrevIsA = true;
            mConditionB.signalAll();
        } finally {
            mLock.unlock();
        }
    }

    private void printB() {
        mLock.lock();
        try {
            while (!mPrevIsA) {
                try {
                    mConditionB.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
            System.out.println("BBBBBBBBBB");
            mPrevIsA = false;
            mConditionA.signalAll();
        } finally {
            mLock.unlock();
        }
    }

    public static void test() {
        ProConCrossTest proConCrossTest = new ProConCrossTest();
        proConCrossTest.start();
    }
}
