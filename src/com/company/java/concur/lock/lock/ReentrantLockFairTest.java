package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFairTest {
    private final ReentrantLock mLock = new ReentrantLock();
    private final ReentrantLock mLock2 = new ReentrantLock(true);
    private final Thread[] mThreads = new Thread[10];

    public void start() {
        for (int i = 0; i < 10; i++) {
            mThreads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    fuck();
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            mThreads[i].start();
        }
    }

    public void start2() {
        for (int i = 0; i < 10; i++) {
            mThreads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    lick();
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            mThreads[i].start();
        }
    }

    private void fuck() {
        mLock.isFair();
        mLock.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getId() + "：持有锁");
        } finally {
            mLock.unlock();
        }
    }

    private void lick() {
        mLock2.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getId() + "：持有锁");
        } finally {
            mLock2.unlock();
        }
    }

    public static void test() {
        ReentrantLockFairTest reentrantLockFairTest = new ReentrantLockFairTest();
        reentrantLockFairTest.start();
    }
    public static void test2() {
        ReentrantLockFairTest reentrantLockFairTest = new ReentrantLockFairTest();
        reentrantLockFairTest.start2();
    }
}
