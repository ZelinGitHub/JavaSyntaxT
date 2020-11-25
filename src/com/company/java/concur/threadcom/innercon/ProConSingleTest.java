package com.company.java.concur.threadcom.innercon;

public class ProConSingleTest {
    private int mData = 0;
    private final String mLock = "abc";

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mLock) {
                        if (mData == 0) {
                            System.out.println("消费者线程：数据为0，执行等待");
                            mLock.wait();
                        }
                        System.out.println("消费者线程：取出数据");
                        mData = 0;
                        System.out.println("消费者线程：唤醒所有阻塞的线程");
                        mLock.notifyAll();
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mLock) {
                        if (mData != 0) {
                            System.out.println("生产者线程：数据不为0，执行等待");
                            mLock.wait();
                        }
                        System.out.println("生产者线程：设置数据");
                        mData = 1;
                        System.out.println("生产者线程：唤醒所有阻塞的线程");
                        mLock.notifyAll();
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();


    }

    public static void test() {
        ProConSingleTest proConSingleTest = new ProConSingleTest();
        proConSingleTest.start();
    }
}
