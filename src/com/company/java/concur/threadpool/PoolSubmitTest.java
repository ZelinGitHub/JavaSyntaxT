package com.company.java.concur.threadpool;

import java.util.concurrent.*;

public class PoolSubmitTest {


    public static void test1() {

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1
                , 1
                , 0
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );
        System.out.println("主线程：向线程池提交任务");
        Future<?> futureTask = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                long tId = Thread.currentThread().getId();
                System.out.println("线程" + tId + "：正在执行任务");
            }
        });
        try {
            System.out.println("主线程：得到任务结果：" + futureTask.get());
        } catch (InterruptedException | ExecutionException pE) {
            pE.printStackTrace();
        }
    }

    public static void test2() {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1
                , 1
                , 0
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );
        System.out.println("主线程：向线程池提交任务");
        String result = "糊弄完了";
        Future<?> futureTask = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                long tId = Thread.currentThread().getId();
                System.out.println("线程" + tId + "：正在执行任务");
            }
        }, result);
        try {
            System.out.println("主线程：得到任务结果：" + futureTask.get());
        } catch (InterruptedException | ExecutionException pE) {
            pE.printStackTrace();
        }
    }

    public static void test3() {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1
                , 1
                , 0
                , TimeUnit.SECONDS
                , linkedBlockingQueue
        );
        System.out.println("主线程：向线程池提交任务");
        Future<?> futureTask = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                long tId = Thread.currentThread().getId();
                System.out.println("线程" + tId + "：正在执行任务");
                return "糊弄完了";
            }
        });
        try {
            System.out.println("主线程：得到任务结果：" + futureTask.get());
        } catch (InterruptedException | ExecutionException pE) {
            pE.printStackTrace();
        }
    }

}
