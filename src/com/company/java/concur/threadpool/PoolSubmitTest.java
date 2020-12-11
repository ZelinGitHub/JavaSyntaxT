package com.company.java.concur.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolSubmitTest {
    public static void test(){
        ExecutorService threadPool = Executors.newCachedThreadPool();

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

    }
}
