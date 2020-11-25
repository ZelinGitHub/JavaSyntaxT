package com.company.java.concur.threadcom.innercon;

import java.util.ArrayList;
import java.util.List;

public class ProConListTest {
    private final List<Integer> mList = new ArrayList<Integer>();
    private final String mLock = "abc";

    public void start() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mLock) {
                        if (!mList.isEmpty()) {
                            System.out.println("生产者线程：容器不为空，执行等待");
                            mLock.wait();
                        }
                        System.out.println("生产者线程：插入数据");
                        mList.add(0);
                        System.out.println("生产者线程：唤醒所有阻塞的线程");
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
                        if (mList.isEmpty()) {
                            System.out.println("消费者线程：容器为空，执行等待");
                            mLock.wait();
                        }
                        System.out.println("消费者线程：取出数据");
                        mList.remove(0);
                        System.out.println("消费者线程：唤醒所有阻塞的线程");
                        mLock.notifyAll();
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();

    }

    public static void test() {
        ProConListTest proConListTest = new ProConListTest();
        proConListTest.start();
    }
}
