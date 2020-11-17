package com.company.java.concur.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    private static void testCreate() {
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(callable);

        MyRunnable myRunnable = new MyRunnable();
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable, "成功");

        Thread thread = new Thread(futureTask);
        thread.start();
    }


    private static void testGet() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                try {
                    Thread.sleep(10000);
                    return "fuck";
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    return pE.getMessage();
                }
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();
        System.out.println("是否完成：" + futureTask.isDone());
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException  ex) {
            ex.printStackTrace();
        }
    }


}
