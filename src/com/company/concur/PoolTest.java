package com.company.concur;

import java.util.concurrent.*;

public class PoolTest {

    public static void test() {

        BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10
                , 15
                , 30
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        ExecutorService threadPool = Executors.newCachedThreadPool();


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是提交给线程池的任务");
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是提交给线程池的任务");
            }
        });

        String result = "我是任务结果";
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是提交给线程池的任务");
            }
        }, result);

        threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我是提交给线程池的任务结果";
            }
        });

        threadPool.shutdown();
        threadPool.shutdownNow();


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是计划线程池的任务");
            }
        }, 10, TimeUnit.SECONDS);

        ScheduledFuture<String> scheduledFuture=scheduledThreadPool.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我是计划线程池的任务结果";
            }
        }, 10, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是计划线程池的任务");
            }
        }, 10, 5, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是计划线程池的任务");
            }
        }, 10, 20, TimeUnit.SECONDS);
    }
}
