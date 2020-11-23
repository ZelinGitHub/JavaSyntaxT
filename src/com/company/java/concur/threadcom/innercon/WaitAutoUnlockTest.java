package com.company.java.concur.threadcom.innercon;

public class WaitAutoUnlockTest {


    public static void test(){
        final String lock="abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1：开始等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("线程1：结束等待");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2：开始等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("线程2：结束等待");
                }
            }
        }).start();
    }
}
