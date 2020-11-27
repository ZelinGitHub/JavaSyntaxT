package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLockTest {

    public static void test() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println("线程1：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程1：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    writeLock.unlock();
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

}
