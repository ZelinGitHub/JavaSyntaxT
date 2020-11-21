package com.company.java.concur.innerlock;

public class MyLockAtomic {
    private static int counter = 0;

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

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            counter++;
        }
        System.out.println(counter);
    }


    private synchronized static void addCount2() {
        for (int i = 0; i < 100; i++) {
            counter++;
        }
        System.out.println(counter);
    }
}
