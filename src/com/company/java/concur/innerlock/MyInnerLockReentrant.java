package com.company.java.concur.innerlock;

public class MyInnerLockReentrant {

    public synchronized void fuck() {
        System.out.println("fuck");
        lick();
    }

    private synchronized void lick() {
        System.out.println("lick");
        kick();
    }

    private synchronized void kick() {
        System.out.println("kick");
    }

    public static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyInnerLockReentrant myInnerLockReentrant=new MyInnerLockReentrant();
                myInnerLockReentrant.fuck();
            }
        }).start();
    }
}
