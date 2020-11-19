package com.company.java.concur.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockTryTest {
    public static void test(){
        Lock reentrantLock = new ReentrantLock();

        reentrantLock.tryLock();

    }
}
