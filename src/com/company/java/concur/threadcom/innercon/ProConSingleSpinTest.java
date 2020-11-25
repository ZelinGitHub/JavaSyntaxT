package com.company.java.concur.threadcom.innercon;

public class ProConSingleSpinTest {
    private int mData = 0;
    private final String mLock = "abc";

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        }).start();
    }


    private void produce() {
        long threadID = Thread.currentThread().getId();
        try {
            synchronized (mLock) {
                while (mData == 0) {
                    System.out.println("消费者线程" + threadID + "：数据为0，执行等待");
                    mLock.wait();
                    System.out.println("消费者线程" + threadID + "：醒来");
                }
                System.out.println("消费者线程" + threadID + "：取出数据");
                mData = 0;
                System.out.println("消费者线程" + threadID + "：唤醒所有阻塞的线程");
                mLock.notifyAll();
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    private void consume() {
        long threadID = Thread.currentThread().getId();

        try {
            synchronized (mLock) {
                while (mData != 0) {
                    System.out.println("生产者线程" + threadID + "：数据不为0，执行等待");
                    mLock.wait();
                    System.out.println("消费者线程" + threadID + "：醒来");
                }
                System.out.println("生产者线程" + threadID + "：设置数据");
                mData = 1;
                System.out.println("生产者线程" + threadID + "：唤醒所有阻塞的线程");
                mLock.notifyAll();
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    public static void test() {
        ProConSingleSpinTest proConTest = new ProConSingleSpinTest();
        proConTest.start();
    }
}
