package com.company.java.concur.innerlock;

public class SyncChunkTest3 {

    public static void test() {
        String lock1 = "abc";
        String lock2 = "abc";
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("thread1 start");
                    System.out.println("thread1 0");
                    System.out.println("thread1 1");
                    System.out.println("thread1 2");
                    System.out.println("thread1 end");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("thread2 start");
                    System.out.println("thread2 0");
                    System.out.println("thread2 1");
                    System.out.println("thread2 2");
                    System.out.println("thread2 end");
                }
            }
        }).start();
    }

}
