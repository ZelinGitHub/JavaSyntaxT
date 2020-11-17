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

    public static void testLock3() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Lock lock = new ReentrantLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 加锁");
                lock.lock();
                System.out.println("线程1 加锁成功");
                try {
                    countDownLatch.countDown();
                    Thread.sleep(10000);
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
                try {
                    countDownLatch.await();
                    System.out.println("线程2 加锁");
                    lock.lock();
                    System.out.println("线程2 加锁成功");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            //消除低层次中断异常捕获
            Thread.currentThread().interrupt();
        }
        System.out.println("主线程 中断线程2");
        thread2.interrupt();
        System.out.println("主线程 线程2的中断状态：" + thread2.isInterrupted());
    }

}
