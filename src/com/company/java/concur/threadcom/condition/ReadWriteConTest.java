package com.company.java.concur.threadcom.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteConTest {

    public static void test(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Condition conditionX = readLock.newCondition();
        Condition conditionY = writeLock.newCondition();
    }
}
