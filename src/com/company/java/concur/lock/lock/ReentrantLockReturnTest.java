package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockReturnTest {

    public static void test() {
        ReentrantLockReturnTest reentrantLockExceptTest = new ReentrantLockReturnTest();
        Lock lock = new ReentrantLock();
        boolean a=true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("线程" + Thread.currentThread().getId() + "：0");
                System.out.println("线程" + Thread.currentThread().getId() + "：1");
                System.out.println("线程" + Thread.currentThread().getId() + "：2");
                if(a){
                    return;
                }else {
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
                    System.out.println("线程" + Thread.currentThread().getId() + "：0");
                    System.out.println("线程" + Thread.currentThread().getId() + "：1");
                    System.out.println("线程" + Thread.currentThread().getId() + "：2");
                    lock.unlock();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
