package com.company.java.concur.threadcom.innercon;

public class WaitNotifyConSpinTest {
    private boolean mIsPeopleAlive = false;
    private final String lock = "abc";

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                kill();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                kill();
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

    private void kill() {
        synchronized (lock) {
            while (!mIsPeopleAlive) {
                System.out.println("线程" + Thread.currentThread().getId() + "：执行条件为false，开始等待");
                try {
                    lock.wait();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getId() + "：结束等待");
            }
            System.out.println("线程" + Thread.currentThread().getId() + "：设置执行条件为false");
            mIsPeopleAlive = false;
        }
    }

    private void generate() {
        synchronized (lock) {
            System.out.println("线程" + Thread.currentThread().getId() + "：设置执行条件为true");
            mIsPeopleAlive = true;
            System.out.println("线程" + Thread.currentThread().getId() + "：唤醒等待的线程们");
            lock.notifyAll();
        }
    }

    public static void test() {
        WaitNotifyConSpinTest waitNotifyConSpinTest = new WaitNotifyConSpinTest();
        waitNotifyConSpinTest.start();
    }
}
