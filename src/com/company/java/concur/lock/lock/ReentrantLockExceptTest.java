package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExceptTest {
    public void fuck(String pNum) {
        System.out.println("线程" + Thread.currentThread().getId() + "：0");
        System.out.println("线程" + Thread.currentThread().getId() + "：1");
        System.out.println("线程" + Thread.currentThread().getId() + "：2");
        int num = Integer.parseInt(pNum);
        System.out.println("线程" + Thread.currentThread().getId() + "：3");
        System.out.println("线程" + Thread.currentThread().getId() + "：4");
        System.out.println("线程" + Thread.currentThread().getId() + "：5");
    }

    public static void test() {
        ReentrantLockExceptTest reentrantLockExceptTest = new ReentrantLockExceptTest();
        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    reentrantLockExceptTest.fuck("a");
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    lock.lock();
                    reentrantLockExceptTest.fuck("200");
                    lock.unlock();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
