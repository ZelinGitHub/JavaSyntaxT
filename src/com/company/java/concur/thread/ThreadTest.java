package com.company.java.concur.thread;

public class ThreadTest {
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("fuck U");
            }
        });

        thread.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Lick me");
            }
        };
        thread1.start();
    }
}
