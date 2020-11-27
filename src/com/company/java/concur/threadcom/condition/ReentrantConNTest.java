package com.company.java.concur.threadcom.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConNTest {
    public static void test() {

        final Lock lock = new ReentrantLock();
        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("线程1：开始等待");
                    condition1.await();
                    System.out.println("线程1：结束等待");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("线程2：开始等待");
                    condition2.await();
                    System.out.println("线程2：结束等待");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        lock.lock();
        try {
            System.out.println("主线程：使用condition1激活所有等待的线程");
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
