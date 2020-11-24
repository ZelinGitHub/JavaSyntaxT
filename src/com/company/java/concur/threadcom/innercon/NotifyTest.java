package com.company.java.concur.threadcom.innercon;

public class NotifyTest {
    public static void test() {
        final String lock = "abc";
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        long threadID = Thread.currentThread().getId();
                        System.out.println("线程" + threadID + "：开始等待");
                        try {
                            lock.wait();
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                        System.out.println("线程" + threadID + "：解除等待");
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    long threadID = Thread.currentThread().getId();
                    System.out.println("线程" + threadID + "：随机唤醒");
                    lock.notify();
                }
            }
        }).start();
    }

    public static void test2() {
        final String lock = "abc";
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        long threadID = Thread.currentThread().getId();
                        System.out.println("线程" + threadID + "：开始等待");
                        try {
                            lock.wait();
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                        System.out.println("线程" + threadID + "：解除等待");
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    long threadID = Thread.currentThread().getId();
                    System.out.println("线程" + threadID + "：多次随机唤醒");
                    lock.notify();
                    lock.notify();
                    lock.notify();
                    lock.notify();
                    lock.notify();
                    lock.notify();
                    lock.notify();
                }
            }
        }).start();
    }

    public static void test3() {
        final String lock = "abc";
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        long threadID = Thread.currentThread().getId();
                        System.out.println("线程" + threadID + "：开始等待");
                        try {
                            lock.wait();
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                        System.out.println("线程" + threadID + "：解除等待");
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            Thread.currentThread().interrupt();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    long threadID = Thread.currentThread().getId();
                    System.out.println("线程" + threadID + "：全部唤醒");
                    lock.notifyAll();
                }
            }
        }).start();
    }
}
