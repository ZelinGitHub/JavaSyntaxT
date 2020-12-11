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
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

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
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
