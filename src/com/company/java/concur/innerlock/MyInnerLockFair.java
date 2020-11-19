package com.company.java.concur.innerlock;

public class MyInnerLockFair {
    public synchronized void fuck(int pTime) throws InterruptedException {
        System.out.println("线程" + Thread.currentThread().getId() + "请求锁成功");
        Thread.sleep(pTime);
    }

    public static void test() {
        MyInnerLockFair myInnerLockFair = new MyInnerLockFair();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程" + Thread.currentThread().getId() + "请求锁");
                    myInnerLockFair.fuck(7000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < 6; i++) {
            final int index = i + 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(index * 500);
                        System.out.println("线程" + Thread.currentThread().getId() + "请求锁");
                        myInnerLockFair.fuck(0);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
