package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLockTest {
    public static void test() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println("线程1：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程1：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println("线程2：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程2：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }).start();
    }
    public static void test2() {
        final ReentrantReadWriteLock reentrantReadWriteLock1 = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock reentrantReadWriteLock2 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock1 = reentrantReadWriteLock1.readLock();
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock2.readLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock1.lock();
                try {
                    System.out.println("线程1：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程1：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    readLock1.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock2.lock();
                try {
                    System.out.println("线程2：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程2：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    readLock2.unlock();
                }
            }
        }).start();
    }
}
