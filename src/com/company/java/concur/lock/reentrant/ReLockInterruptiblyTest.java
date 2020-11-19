package com.company.java.concur.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockInterruptiblyTest {
    public static void test(){
        Lock reentrantLock = new ReentrantLock();

        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
