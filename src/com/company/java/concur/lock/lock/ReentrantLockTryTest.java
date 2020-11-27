package com.company.java.concur.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryTest {
    public static void test() {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                System.out.println("加锁");
                if (lock.tryLock()) {
                    System.out.println("加锁成功");
                    try {
                        System.out.println("我是线程1");
                    }finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("锁测试失败");
                }
            }
        });
        thread.start();
    }
}
