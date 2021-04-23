package com.company.java.concur.threadpool;

import java.util.concurrent.*;

public class PoolCreateTest {
    public void createPoolOrigin() {
        //创建阻塞队列
        //类型参数是Runnable
        BlockingQueue<Runnable> linkedBlockingQueue
                = new LinkedBlockingQueue<Runnable>(
                20
        );
        //创建ThreadPoolExecutor实例（线程池）
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10
                , 15
                , 30
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );
    }

    public void createPoolOrigin2() {
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


    public void createPoolByExecutors() {
        //创建缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //创建单一线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //创建固定线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
    }
}
