package com.company.java.concur.innerlock;

public class SyncChunkTest2 {

    public static void test() {
        MyLock myLock = new MyLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock) {
                    System.out.println("die start");
                    System.out.println("die 0");
                    System.out.println("die 1");
                    System.out.println("die 2");
                    System.out.println("die end");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myLock.fuck();
            }
        }).start();
    }

    static class MyLock {
        public synchronized void fuck() {
            System.out.println("fuck start");
            System.out.println("fuck 0");
            System.out.println("fuck 1");
            System.out.println("fuck 2");
            System.out.println("fuck end");
        }
    }
}
