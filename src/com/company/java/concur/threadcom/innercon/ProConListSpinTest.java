package com.company.java.concur.threadcom.innercon;

import java.util.ArrayList;
import java.util.List;

public class ProConListSpinTest {
    private final List<Integer> mList = new ArrayList<Integer>();
    private final String mLock = "abc";
    public void start() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    produce();
                }
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    consume();
                }
            }).start();
        }
    }

    private void produce() {
        long threadID = Thread.currentThread().getId();

        try {
            synchronized (mLock) {
                while (!mList.isEmpty()) {
                    System.out.println("生产者线程" + threadID + "：容器不为空，执行等待");
                    mLock.wait();
                    System.out.println("生产者线程" + threadID + "：醒来");
                }
                System.out.println("生产者线程" + threadID + "：插入数据");
                mList.add(0);
                System.out.println("生产者线程" + threadID + "：唤醒所有阻塞的线程");
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
                while (mList.isEmpty()) {
                    System.out.println("消费者线程" + threadID + "：容器为空，执行等待");
                    mLock.wait();
                    System.out.println("消费者线程" + threadID + "：醒来");
                }
                System.out.println("消费者线程" + threadID + "：数据个数为" + mList.size() + "，取出数据");
                mList.remove(0);
                System.out.println("消费者线程" + threadID + "：唤醒所有阻塞的线程");
                mLock.notifyAll();
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    public static void test() {
        ProConListSpinTest proConListSpinTest = new ProConListSpinTest();
        proConListSpinTest.start();
    }
}
