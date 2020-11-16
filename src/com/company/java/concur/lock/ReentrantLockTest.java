package com.company.java.concur.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static void testReentrantLock() {
        Lock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.tryLock();


        try {
            reentrantLock.tryLock(2000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Condition condition = reentrantLock.newCondition();

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            condition.await(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        condition.signalAll();
        condition.signal();
    }
}
