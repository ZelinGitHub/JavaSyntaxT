package com.company.concur;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void test() {
    }

    private static void testFutureTask() {
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(callable);

        MyRunnable myRunnable = new MyRunnable();
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable, "成功");

        Thread thread = new Thread(futureTask);
        thread.start();
    }

    private static void testInterrupt() {
        Thread curThread = Thread.currentThread();
        boolean isInterrupted = curThread.isInterrupted();
        boolean isInterruptedX = Thread.interrupted();
        curThread.interrupt();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是正在执行的线程");
                if(Thread.interrupted()){
                    System.out.println("中断状态为true，我选择结束运行");
                    return;
                }else {

                }
            }
        }).start();
    }

    public static void testJoin(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1开始运行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1结束运行");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始运行");
                try {
                    //阻塞，等待线程1运行结束
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2结束运行");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始运行");
                try {
                    thread1.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2结束运行");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
