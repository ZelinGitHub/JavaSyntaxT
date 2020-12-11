package com.company.java.concur.lock.other;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void test() {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long threadId = Thread.currentThread().getId();
                    try {
                        System.out.println("线程" + threadId + "：请求锁");
                        semaphore.acquire();
                        System.out.println("线程" + threadId + "：请求锁成功");
                        Thread.sleep(3000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    } finally {
                        System.out.println("线程" + threadId + "：放弃锁");
                        semaphore.release();
                    }
                }
            }).start();
        }

    }
}
