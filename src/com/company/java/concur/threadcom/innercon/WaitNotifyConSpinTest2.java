package com.company.java.concur.threadcom.innercon;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyConSpinTest2 {
    private final List<String> mData = new ArrayList<String>();
    private final String mLock = "abc";

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                use();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                use();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                generate();
            }
        }).start();
    }

    private void use() {
        synchronized (mLock) {
            while (mData.isEmpty()) {
                System.out.println("线程" + Thread.currentThread().getId() + "：容器为空，开始等待");
                try {
                    mLock.wait();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getId() + "：结束等待");
            }
            System.out.println("线程" + Thread.currentThread().getId() + "：消耗一个数据");
            mData.remove(0);
        }
    }

    private void generate() {
        synchronized (mLock) {
            System.out.println("线程" + Thread.currentThread().getId() + "：生成一个数据，添加到容器");
            mData.add("data");
            System.out.println("线程" + Thread.currentThread().getId() + "：唤醒等待的线程们");
            mLock.notifyAll();
        }
    }

    public static void test() {
        WaitNotifyConSpinTest2 waitNotifyConSpinTest2 = new WaitNotifyConSpinTest2();
        waitNotifyConSpinTest2.start();
    }
}
