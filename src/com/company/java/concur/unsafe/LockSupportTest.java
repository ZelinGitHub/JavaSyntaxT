package com.company.java.concur.unsafe;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是当前线程");

                LockSupport.park();

            }
        });

        thread.start();
    }

    public static void testInterrupt() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程2，我要暂停");
                LockSupport.park();
                System.out.println("我是线程2，我恢复了");
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("我是线程1，我要中断线程2");
        thread.interrupt();
    }
    public static void testInterrupt2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程2，我要暂停");
                LockSupport.park();
                System.out.println("我是线程2，我恢复了");
                Thread.interrupted();
                System.out.println("我是线程2，我要第二次暂停");
                LockSupport.park();
                System.out.println("我是线程2，我第二次恢复了");
                System.out.println("我是线程2，我要第三次暂停");
                LockSupport.park();
                System.out.println("我是线程2，我第三次恢复了");
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("我是线程1，我要中断线程2");
        thread.interrupt();
    }
}
