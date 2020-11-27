package com.company.java.concur.threadcom.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConSortTest {
    private int mNum = 1;
    private final ReentrantLock mLock = new ReentrantLock();
    private final Condition mCondition1 = mLock.newCondition();
    private final Condition mCondition2 = mLock.newCondition();
    private final Condition mCondition3 = mLock.newCondition();


    public void fuck() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mLock.lock();
                    try {
                        while (mNum != 1) {
                            mCondition1.await();
                        }
                        System.out.println("线程1");
                        mNum = 2;
                        mCondition2.signalAll();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        mLock.unlock();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mLock.lock();
                    try {
                        while (mNum != 2) {
                            mCondition2.await();
                        }
                        System.out.println("线程2");
                        mNum = 3;
                        mCondition3.signalAll();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        mLock.unlock();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mLock.lock();
                    try {
                        while (mNum != 3) {
                            mCondition3.await();
                        }
                        System.out.println("线程3");
                        mNum = 1;
                        mCondition1.signalAll();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        mLock.unlock();
                    }
                }
            }).start();
        }
    }

    public static void test() {
        ReentrantConSortTest reentrantConSortTest = new ReentrantConSortTest();
        reentrantConSortTest.fuck();
    }
}
