package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteLockTest {
    public static void test() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
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
        ReentrantReadWriteLock.WriteLock writeLock1 = reentrantReadWriteLock1.writeLock();
        ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock1.lock();
                try {
                    System.out.println("线程1：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程1：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    writeLock1.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock2.lock();
                try {
                    System.out.println("线程2：开始执行");
                    Thread.sleep(2000);
                    System.out.println("线程2：结束执行");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    writeLock2.unlock();
                }
            }
        }).start();
    }
}
