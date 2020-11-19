package com.company.java.concur.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockTest {

    private static void test() {
        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}
