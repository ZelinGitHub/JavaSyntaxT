package com.company.java.concur.innerlock;

public class MyInnerLock {
    public int mNum = 0;
    public void fuck() throws InterruptedException {
        mNum+=100;
        Thread.sleep(1000);
        System.out.println("线程"+Thread.currentThread().getId()+"：num="+mNum);
    }
    public synchronized void fuck2() throws InterruptedException {
        mNum+=100;
        Thread.sleep(1000);
        System.out.println("线程"+Thread.currentThread().getId()+"：num="+mNum);
    }

    public static void test() {
        MyInnerLock myInnerLock = new MyInnerLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock.fuck();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock.fuck();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

    public void lick() throws InterruptedException {
        System.out.println("第一步");
        Thread.sleep(2000);
        System.out.println("第二步");
    }
    public synchronized void lick2() throws InterruptedException {
        System.out.println("第一步");
        Thread.sleep(2000);
        System.out.println("第二步");
    }



    public static void test2() {
        MyInnerLock myInnerLock = new MyInnerLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock.lick2();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock.lick2();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

    public static void test3() {
        MyInnerLock myInnerLock = new MyInnerLock();
        MyInnerLock myInnerLock2 = new MyInnerLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock.lick2();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLock2.lick2();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }
}
