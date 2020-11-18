package com.company.java.concur.innerlock;

public class MyInnerLockX {

    public synchronized void fuck() {
        System.out.println("fuck start");
        System.out.println("fuck 0");
        System.out.println("fuck 1");
        System.out.println("fuck 2");
        System.out.println("fuck end");
    }

    public synchronized void lick() {
        System.out.println("lick start");
        System.out.println("lick 0");
        System.out.println("lick 1");
        System.out.println("lick 2");
        System.out.println("lick end");
    }

    public synchronized void suck() {
        System.out.println("suck start");
        System.out.println("suck 0");
        System.out.println("suck 1");
        System.out.println("suck 2");
        System.out.println("suck end");
    }

    public static void test() {
        MyInnerLockX myInnerLock = new MyInnerLockX();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myInnerLock.fuck();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myInnerLock.lick();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myInnerLock.suck();
            }
        }).start();
    }
}
