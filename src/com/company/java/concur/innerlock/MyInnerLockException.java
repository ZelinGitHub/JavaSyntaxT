package com.company.java.concur.innerlock;

public class MyInnerLockException {
    public synchronized void fuck(String pNum) {
        System.out.println("线程" + Thread.currentThread().getId() + "：0");
        System.out.println("线程" + Thread.currentThread().getId() + "：1");
        System.out.println("线程" + Thread.currentThread().getId() + "：2");
        int num = Integer.parseInt(pNum);
        System.out.println("线程" + Thread.currentThread().getId() + "：3");
        System.out.println("线程" + Thread.currentThread().getId() + "：4");
        System.out.println("线程" + Thread.currentThread().getId() + "：5");
    }

    public static void test() {
        MyInnerLockException myInnerLockException = new MyInnerLockException();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myInnerLockException.fuck("100");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    myInnerLockException.fuck("200");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
