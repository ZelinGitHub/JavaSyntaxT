package com.company.java.concur.threadcom.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockConTest {
    public void test(){
        Lock reentrantLock = new ReentrantLock();

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
