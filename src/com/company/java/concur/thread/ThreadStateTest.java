package com.company.java.concur.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStateTest {
    public static void test1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：线程1的状态为"
                        + Thread.currentThread().getState());
            }
        });
        System.out.println("主线程：线程1的状态为" + thread1.getState());
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }

    public static void test2() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1：准备睡眠");
                    Thread.sleep(10000);
                    System.out.println("线程1：结束睡眠");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }

    public static void test3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：请求锁");
                synchronized (ThreadStateTest.class) {
                    System.out.println("线程1：请求锁成功");
                    System.out.println("线程1：放弃锁");
                }
            }
        });
        System.out.println("主线程：请求锁");
        synchronized (ThreadStateTest.class) {
            System.out.println("主线程：请求锁成功");
            thread1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
            System.out.println("主线程：线程1的状态为" + thread1.getState());
            System.out.println("主线程：放弃锁");
        }
    }

    public static void test4() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadStateTest.class) {
                    try {
                        System.out.println("线程1：准备等待");
                        ThreadStateTest.class.wait();
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }

    public static void test5() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadStateTest.class) {
                    try {
                        System.out.println("线程1：准备等待");
                        ThreadStateTest.class.wait(2000);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }

    public static void test6() {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：请求锁");
                reentrantLock.lock();
                System.out.println("线程1：请求锁成功");
                System.out.println("线程1：放弃锁");
                reentrantLock.unlock();
            }
        });
        System.out.println("主线程：请求锁");
        reentrantLock.lock();
        System.out.println("主线程：请求锁成功");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
        System.out.println("主线程：放弃锁");
        reentrantLock.unlock();
    }

    public static void test7() {
        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition = reentrantLock.newCondition();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("线程1：准备等待");
                    condition.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });

        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }

    public static void test8() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("线程1：准备等待");
                    condition.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                reentrantLock.unlock();
            }
        });

        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程1的状态为" + thread1.getState());
    }
}
