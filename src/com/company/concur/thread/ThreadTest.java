package com.company.concur.thread;

import com.company.concur.runnable.MyCallable;
import com.company.concur.runnable.MyRunnable;

import java.util.concurrent.FutureTask;

public class ThreadTest {


    private static void testFutureTask() {
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(callable);

        MyRunnable myRunnable = new MyRunnable();
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable, "成功");

        Thread thread = new Thread(futureTask);
        thread.start();
    }



    public static void testJoin() {
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
