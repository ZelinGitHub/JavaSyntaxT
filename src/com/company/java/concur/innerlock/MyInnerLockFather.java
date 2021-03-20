package com.company.java.concur.innerlock;

public class MyInnerLockFather {

    public synchronized void fuck() throws InterruptedException {
        System.out.println("fuck第一步");
        Thread.sleep(1000);
        System.out.println("fuck第二步");
    }

    static class Son extends MyInnerLockFather {
        public synchronized void lick() throws InterruptedException {
            System.out.println("lick第一步");
            Thread.sleep(1000);
            System.out.println("lick第二步");
        }

        @Override
        public void fuck() throws InterruptedException {
            System.out.println("fuck第一步");
            Thread.sleep(1000);
            System.out.println("fuck第二步");
        }
    }

    public static void test() {
        Son son = new Son();
        MyInnerLockFather father = new MyInnerLockFather();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    son.lick();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    son.fuck();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
