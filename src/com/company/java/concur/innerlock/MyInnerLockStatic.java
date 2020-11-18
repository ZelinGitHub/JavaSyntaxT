package com.company.java.concur.innerlock;

public class MyInnerLockStatic {

    public synchronized static void fuck() {
        System.out.println("fuck start");
        System.out.println("fuck 0");
        System.out.println("fuck 1");
        System.out.println("fuck 2");
        System.out.println("fuck end");
    }

    public synchronized static void lick() {
        System.out.println("lick start");
        System.out.println("lick 0");
        System.out.println("lick 1");
        System.out.println("lick 2");
        System.out.println("lick end");
    }

    public synchronized static void suck() {
        System.out.println("suck start");
        System.out.println("suck 0");
        System.out.println("suck 1");
        System.out.println("suck 2");
        System.out.println("suck end");
    }

    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                fuck();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lick();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                suck();
            }
        }).start();
    }
}
