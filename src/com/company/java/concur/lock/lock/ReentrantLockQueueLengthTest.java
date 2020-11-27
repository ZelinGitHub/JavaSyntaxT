package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockQueueLengthTest {
    public static void test() {

        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("线程" + Thread.currentThread().getId() + "：正在运行");
                    Thread.sleep(30000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    try {
                        System.out.println("线程" + Thread.currentThread().getId() + "：正在运行");
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：请求锁失败而阻塞的线程个数为" + reentrantLock.getQueueLength());
    }

    public static void test2() {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    try {
                        condition.await();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }

        reentrantLock.lock();
        try {
            System.out.println("主线程：因Condition而等待的线程个数为"
                    + reentrantLock.getWaitQueueLength(condition));
        } finally {
            reentrantLock.unlock();
        }
    }
}
