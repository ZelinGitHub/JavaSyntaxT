package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHasQueuedTest {
    public static void test() {

        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("线程1：我是线程1");
                    Thread.sleep(30000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("线程2：我是线程2");
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }

        System.out.println(
                "主线程：线程1是否被锁阻塞的查询结果为" + reentrantLock.hasQueuedThread(thread1)
        );
        System.out.println(
                "主线程：线程2是否被锁阻塞的查询结果为" + reentrantLock.hasQueuedThread(thread2)
        );
        System.out.println(
                "主线程：是否有线程被锁阻塞的查询结果为" + reentrantLock.hasQueuedThreads()
        );
    }

    public static void test2() {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }

        reentrantLock.lock();
        try {
            System.out.println(
                    "主线程：是否有线程因锁的Condition等待的查询结果为" + reentrantLock.hasWaiters(condition)
            );
        } finally {
            reentrantLock.unlock();
        }
    }
}
