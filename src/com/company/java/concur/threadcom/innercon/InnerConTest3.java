package com.company.java.concur.threadcom.innercon;

public class InnerConTest3 {

    private int mMoney = 0;

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mMoney = 0;
                fuck();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mMoney = 10000;
                fuck();
            }
        }).start();
    }

    private void fuck() {
        synchronized (this) {
            while (mMoney <= 2000) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("hot fucking now");
            this.notifyAll();
        }
    }
}
