package com.company.concur;

public class InnerLockTest {


    public static void test(){


        new Thread(new Runnable() {
            @Override
            public void run() {
                fuck(0);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fuck(20000);
            }
        }).start();
    }

    private static void fuck(int pMoney) {
        synchronized (InnerLockTest.class){
            while (pMoney <=2000){
                try {
                    InnerLockTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("hot fucking now");
            InnerLockTest.class.notifyAll();
        }
    }
}
