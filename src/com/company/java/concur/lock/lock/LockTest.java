package com.company.java.concur.lock.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void testLock() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                System.out.println("线程1 加锁");
                lock.lock();
                System.out.println("线程1 加锁成功");
                try {
                    System.out.println("我是线程1");
                } finally {
                    System.out.println("线程1 解锁");
                    lock.unlock();
                    System.out.println("线程1 解锁成功");
                }
            }
        });
        thread.start();
    }


    public static void testLock2() {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 加锁");
                lock.lock();
                System.out.println("线程1 加锁成功");
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("线程1 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (Exception pE) {
                    pE.printStackTrace();
                } finally {
                    System.out.println("线程1 解锁");
                    lock.unlock();
                    System.out.println("线程1 解锁成功");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 加锁");
                lock.lock();
                System.out.println("线程2 加锁成功");
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("线程2 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (Exception pE) {
                    pE.printStackTrace();
                } finally {
                    System.out.println("线程2 解锁");
                    lock.unlock();
                    System.out.println("线程2 解锁成功");
                }
            }
        });
        thread.start();
        thread2.start();
    }


}
