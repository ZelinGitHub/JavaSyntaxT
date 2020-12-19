package com.company.java.concur.threadpool;

import java.util.concurrent.*;

public class PoolExecuteTest {
    public static void test() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是提交给线程池的任务");
            }
        });
    }

    public static void test2() {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                //参数1核心线程数
                1
                //参数2总线程数
                , 2
                //参数3线程存活时间，默认对核心线程数无效
                , 10
                //参数4线程存活时间单位
                , TimeUnit.SECONDS
                //参数5阻塞队列
                , linkedBlockingQueue
        );

        //提交三个任务
        //第一个任务，创建核心线程执行
        //第二个任务，放到阻塞队列
        //第三个任务，创建非核心线程执行
        //核心线程，执行完任务1，从阻塞队列取出任务2执行
        //非核心线程，执行完任务3，从阻塞队列取出任务，阻塞10s
        //核心线程，执行完任务2，从阻塞队列取出任务，阻塞10s

        for(int i=0;i<3;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    long tId=Thread.currentThread().getId();
                    System.out.println("线程"+tId+"：执行任务");
                }
            });
        }
    }
}
