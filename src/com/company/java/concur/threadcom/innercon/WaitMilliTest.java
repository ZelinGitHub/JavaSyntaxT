package com.company.java.concur.threadcom.innercon;

public class WaitMilliTest {
    public static void test(){
        final String lock="abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("线程1：开始等待");
                        lock.wait(5000);
                        System.out.println("线程1：结束等待");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public static void test2(){
        final String lock="abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("线程1：开始等待");
                        lock.wait(5000);
                        System.out.println("线程1：结束等待");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
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
        synchronized (lock){
            System.out.println("线程2：唤醒线程1");
            lock.notifyAll();
        }
    }
}
