package com.company.java.concur.vol;

public class VolatileTest3 {
    private static volatile int counter = 0;

    public static void test() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    addCount();
                }
            });
            thread.start();
        }
    }

    private synchronized static void addCount() {
        for (int i = 0; i < 100; i++) {
            counter++;
        }
        System.out.println(counter);
    }
}
