package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHoldCountTest {
    private final ReentrantLock mLock = new ReentrantLock();

    public void start() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                fuck();
            }
        });
        thread.start();
    }

    private void fuck() {
        System.out.println("线程1：加锁");
        mLock.lock();
        try {
            System.out.println("线程1：持有锁次数为" + mLock.getHoldCount());
            lick();
        } finally {
            System.out.println("线程1：解锁");
            mLock.unlock();
        }
    }

    private void lick() {
        System.out.println("线程1：加锁");
        mLock.lock();
        try {
            System.out.println("线程1：持有锁次数为" + mLock.getHoldCount());
            kill();
        } finally {
            System.out.println("线程1：解锁");
            mLock.unlock();
        }
    }

    private void kill() {
        System.out.println("线程1：加锁");
        mLock.lock();
        try {
            System.out.println("线程1：持有锁次数为" + mLock.getHoldCount());
        } finally {
            System.out.println("线程1：解锁");
            mLock.unlock();
        }
    }

    public static void test() {
        ReentrantLockHoldCountTest reentrantLockHoldCountTest = new ReentrantLockHoldCountTest();
        reentrantLockHoldCountTest.start();
    }
}
