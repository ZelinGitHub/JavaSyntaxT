package com.company.java.concur.lock.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryMilliTest {

    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock lock = new ReentrantLock();
                try {
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("我是线程1");
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println("尝试加锁失败");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void test2() {
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 准备请求锁");
                lock.lock();
                System.out.println("线程1 请求锁成功");
                try {
                    countDownLatch.countDown();
                    System.out.println("线程1 我是线程1");
                    Thread.sleep(8000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    System.out.println("线程1 放弃锁");
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("线程2 准备请求锁");
                    if (lock.tryLock(60, TimeUnit.SECONDS)) {
                        System.out.println("线程2 请求锁成功");
                        try {
                            System.out.println("线程2 我是线程2");
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println("线程2 尝试加锁失败");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

    public static void test3() {
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 准备请求锁");
                lock.lock();
                System.out.println("线程1 请求锁成功");
                try {
                    countDownLatch.countDown();
                    System.out.println("线程1 我是线程1");
                    Thread.sleep(10000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    System.out.println("线程1 放弃锁");
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("线程2 准备请求锁");
                    if (lock.tryLock(22, TimeUnit.SECONDS)) {
                        System.out.println("线程2 请求锁成功");
                        try {
                            Thread.sleep(10000);
                            System.out.println("线程2 我是线程2");
                        } finally {
                            System.out.println("线程2 放弃锁");
                            lock.unlock();
                        }
                    } else {
                        System.out.println("线程2 尝试加锁失败");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("线程3 准备请求锁");
                    if (lock.tryLock(22, TimeUnit.SECONDS)) {
                        System.out.println("线程3 请求锁成功");
                        try {
                            Thread.sleep(10000);
                            System.out.println("线程3 我是线程3");
                        } finally {
                            System.out.println("线程3 放弃锁");
                            lock.unlock();
                        }
                    } else {
                        System.out.println("线程3 尝试加锁失败");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
    }

    public static void test4() {
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 准备请求锁");
                lock.lock();
                System.out.println("线程1 请求锁成功");
                try {
                    countDownLatch.countDown();
                    System.out.println("线程1 我是线程1");
                    Thread.sleep(8000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                } finally {
                    System.out.println("线程1 放弃锁");
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("线程2 准备请求锁");
                    if (lock.tryLock(3, TimeUnit.SECONDS)) {
                        System.out.println("线程2 请求锁成功");
                        try {
                            System.out.println("线程2 我是线程2");
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println("线程2 计时锁测试失败");
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

}
