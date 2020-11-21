package com.company.java.concur.innerlock;

public class SyncChunkTest2 {

    public static void test() {
        MyLock myLock = new MyLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock) {
                    try {
                        System.out.println("die start");
                        Thread.sleep(2000);
                        System.out.println("die end");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
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
            try {
                System.out.println("fuck start");
                Thread.sleep(2000);
                System.out.println("fuck end");
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
        }
    }
}
