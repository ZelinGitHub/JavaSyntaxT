package com.company.concur.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

    private static void testLock() {
    }

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

        Condition condition= reentrantLock.newCondition();

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            condition.await(20,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        condition.signalAll();
        condition.signal();
    }

    private static void testReadWriteLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Condition conditionX=readLock.newCondition();
        Condition conditionY=writeLock.newCondition();

        readLock.lock();
        writeLock.lock();

        readLock.tryLock();
        writeLock.tryLock();
    }

}
