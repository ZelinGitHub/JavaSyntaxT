package com.company.java.concur.threadpool;

import java.util.concurrent.*;

public class ScheduledPoolTest {
    public static void test(){

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
