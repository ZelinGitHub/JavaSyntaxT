package com.company.java.concur.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockReentrantTest {
    public static void test1() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：加读锁");
                readLock.lock();
                try {
                    System.out.println("线程1：加读锁");
                    readLock.lock();
                    try {
                        System.out.println("线程1：正在执行");
                    } finally {
                        System.out.println("线程1：解读锁");
                        readLock.unlock();
                    }
                } finally {
                    System.out.println("线程1：解读锁");
                    readLock.unlock();
                }
            }
        }).start();
    }

    public static void test2() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：加写锁");
                writeLock.lock();
                try {
                    System.out.println("线程1：加写锁");
                    writeLock.lock();
                    try {
                        System.out.println("线程1：正在执行");
                    } finally {
                        System.out.println("线程1：解写锁");
                        writeLock.unlock();
                    }
                } finally {
                    System.out.println("线程1：解写锁");
                    writeLock.unlock();
                }
            }
        }).start();
    }

    public static void test3() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：加读锁");
                readLock.lock();
                try {
                    System.out.println("线程1：加写锁");
                    writeLock.lock();
                    try {
                        System.out.println("线程1：正在执行");
                    } finally {
                        System.out.println("线程1：解写锁");
                        writeLock.unlock();
                    }
                } finally {
                    System.out.println("线程1：解读锁");
                    readLock.unlock();
                }
            }
        }).start();
    }

    public static void test4() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：加写锁");
                writeLock.lock();
                try {
                    System.out.println("线程1：加读锁");
                    readLock.lock();
                    try {
                        System.out.println("线程1：正在执行");
                    } finally {
                        System.out.println("线程1：解读锁");
                        readLock.unlock();
                    }
                } finally {
                    System.out.println("线程1：解写锁");
                    writeLock.unlock();
                }
            }
        }).start();
    }

    public static void test4__() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：加写锁");
                writeLock.lock();
                try {
                    System.out.println("线程1：加读锁");
                    readLock.lock();
                    try {
                        System.out.println("线程1：正在执行");
                    } finally {
                        System.out.println("线程1：解写锁");
                        writeLock.unlock();
                    }
                } finally {
                    System.out.println("线程1：解读锁");
                    readLock.unlock();
                }
            }
        }).start();
    }
}

