package com.company.java.concur.threadpool;

import java.util.concurrent.*;

public class PoolCreateTest {
    public static void test(){
        BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10
                , 15
                , 30
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

    }

    public static void test2(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }
}
