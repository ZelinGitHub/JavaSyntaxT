package com.company.java.concur.thread;

public class ThreadGroupTest {
    public static void test1() {
        System.out.println("主线程：创建线程组1");
        ThreadGroup threadGroup = new ThreadGroup("线程组1");
        System.out.println("主线程：创建线程1和线程2");
        Thread thread1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1：正在运行");
                    Thread.sleep(10000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2：正在运行");
                    Thread.sleep(10000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        System.out.println("主线程：线程组1的活动线程个数为" + threadGroup.activeCount());
        System.out.println("主线程：开启线程1");
        thread1.start();
        System.out.println("主线程：线程组1的活动线程个数为" + threadGroup.activeCount());
        System.out.println("主线程：开启线程2");
        thread2.start();
        System.out.println("主线程：线程组1的活动线程个数为" + threadGroup.activeCount());
        System.out.println("主线程：睡眠1s");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：线程组1的活动线程个数为" + threadGroup.activeCount());
    }

    public static void test2() {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程：主线程的线程组是" + mainGroup.getName());
        ThreadGroup systemGroup = mainGroup.getParent();
        System.out.println("主线程：主线程的线程组的父线程组是" + systemGroup.getName());
        ThreadGroup noGroup = systemGroup.getParent();
        System.out.println("主线程：主线程的线程组的爷爷线程组是" + noGroup.getName());
    }

    public static void test3() {
        ThreadGroup threadGroup = new ThreadGroup("线程组1");
        Thread thread1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：开始运行");
                while (!Thread.currentThread().isInterrupted()) {
                }
                System.out.println("线程1：结束运行");
            }
        });
        Thread thread2 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2：开始运行");
                while (!Thread.currentThread().isInterrupted()) {
                }
                System.out.println("线程2：结束运行");
            }
        });
        Thread thread3 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3：开始运行");
                while (!Thread.currentThread().isInterrupted()) {
                }
                System.out.println("线程3：结束运行");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        System.out.println("主线程：中断线程组");
        threadGroup.interrupt();
    }

    public static void test4(){
        ThreadGroup threadGroup=new ThreadGroup("线程组1");
        ThreadGroup[] threadGroups=new ThreadGroup[threadGroup.activeGroupCount()];
        threadGroup.enumerate(threadGroups);
        threadGroup.enumerate(threadGroups,false);
    }
    public static void test5(){
        ThreadGroup threadGroup=new ThreadGroup("线程组1");


    }
}
