package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void test() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
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
                writeLock.lock();
                try {
                    System.out.println("线程2：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程2：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        }).start();
    }
    public static void test2() {
        final ReentrantReadWriteLock reentrantReadWriteLock1 = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock reentrantReadWriteLock2 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock1.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock2.writeLock();
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
                writeLock.lock();
                try {
                    System.out.println("线程2：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程2：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        }).start();
    }

}
