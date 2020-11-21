package com.company.java.concur.innerlock;

public class SyncChunkTest3 {

    public static void test() {
        String lock1 = "abc";
        String lock2 = "abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        System.out.println("thread1 start");
                        Thread.sleep(2000);
                        System.out.println("thread1 end");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        System.out.println("thread2 start");
                        Thread.sleep(2000);
                        System.out.println("thread2 end");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static String lock;

    public static void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock = "abc";
                synchronized (lock) {
                    try {
                        System.out.println("thread1 start");
                        Thread.sleep(2000);
                        System.out.println("thread1 end");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    lock = "bcd";
                    synchronized (lock) {
                        System.out.println("thread2 start");
                        Thread.sleep(2000);
                        System.out.println("thread2 end");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }

}
