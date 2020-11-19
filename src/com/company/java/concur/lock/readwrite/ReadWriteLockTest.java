package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private static void testReadWriteLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Condition conditionX = readLock.newCondition();
        Condition conditionY = writeLock.newCondition();

        readLock.lock();
        writeLock.lock();

        readLock.tryLock();
        writeLock.tryLock();
    }

}
