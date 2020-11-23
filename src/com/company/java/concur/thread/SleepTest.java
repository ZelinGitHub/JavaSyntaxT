package com.company.java.concur.thread;

public class SleepTest {


    public static void test(){
        final String lock="abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1：开始睡眠");
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("线程1：结束睡眠");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2：开始睡眠");
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("线程2：结束睡眠");
                }
            }
        }).start();
    }
}
