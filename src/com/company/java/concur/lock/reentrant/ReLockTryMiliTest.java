package com.company.java.concur.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockTryMiliTest {
    public static void test(){
        Lock reentrantLock = new ReentrantLock();

        try {
            reentrantLock.tryLock(2000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
