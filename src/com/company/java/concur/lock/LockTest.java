package com.company.java.concur.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    public static void testLock() {
        Lock lock = new ReentrantLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 加锁");
                lock.lock();
                System.out.println("线程1 加锁成功");
                try {
                    for(int i=0;i<3;i++){
                        System.out.println("线程1 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    //消除低层次中断异常捕获
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程1 解锁");
                lock.unlock();
                System.out.println("线程1 解锁成功");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 加锁");
                lock.lock();
                System.out.println("线程2 加锁成功");
                try {
                    for(int i=0;i<3;i++){
                        System.out.println("线程2 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    //消除低层次中断异常捕获
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程2 解锁");
                lock.unlock();
                System.out.println("线程2 解锁成功");
            }
        });
        thread.start();
        thread2.start();
    }

    public static void testLock2() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Lock lock = new ReentrantLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 加锁");

                lock.lock();
                System.out.println("线程1 加锁成功");
                countDownLatch.countDown();

                try {
                    for(int i=0;i<5;i++){
                        System.out.println("线程1 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    //消除低层次中断异常捕获
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程1 解锁");
                lock.unlock();
                System.out.println("线程1 解锁成功");
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    //消除低层次中断异常捕获
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程2 加锁");
                lock.lock();
                System.out.println("线程2 加锁成功");
                try {
                    for(int i=0;i<5;i++){
                        System.out.println("线程2 正在运行");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    //消除低层次中断异常捕获
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程2 解锁");
                lock.unlock();
                System.out.println("线程2 解锁成功");
            }
        });

        thread2.start();

    }

    public static void testLockInterrupt() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    public static void testLockTry() {
        Lock lock = new ReentrantLock();
        if (lock.tryLock()) {
            lock.unlock();
        } else {
            System.out.println("尝试加锁失败");
        }
    }

    public static void testLockTryMilli() {
        Lock lock = new ReentrantLock();
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                lock.unlock();
            } else {
                System.out.println("尝试加锁失败");
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

}
