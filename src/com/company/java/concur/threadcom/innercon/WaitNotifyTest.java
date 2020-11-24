package com.company.java.concur.threadcom.innercon;

public class WaitNotifyTest {

    public static void test() {
        final String lock = "abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程1：我阻塞了");
                    try {
                        lock.wait();
                        System.out.println("线程1：我醒来了");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                        System.out.println("线程1：我醒来了");
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2：我要唤醒线程1");
                    lock.notifyAll();
                }
            }
        }).start();
    }
}
