package com.company.java.concur.lock.reentrant;

import com.company.java.concur.innerlock.MyInnerLockFair;

import java.util.concurrent.locks.ReentrantLock;

public class ReLockFairTest {
    ReentrantLock reentrantLock = new ReentrantLock(true);
    ReentrantLock reentrantLock2 = new ReentrantLock();

    public void fuck(int pTime) {
        System.out.println("线程" + Thread.currentThread().getId() + "请求锁");
        reentrantLock.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getId() + "请求锁成功");
            Thread.sleep(pTime);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void test() {
        ReLockFairTest reLockFairTest = new ReLockFairTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reLockFairTest.fuck(3000);
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reLockFairTest.fuck(500);
                }
            }).start();
        }

    }
}
