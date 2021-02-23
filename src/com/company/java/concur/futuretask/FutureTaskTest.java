package com.company.java.concur.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    private void fuck() {
        MyCallable callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

    private void sick() {
        MyRunnable myRunnable = new MyRunnable();
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable, "成功");
        Thread thread = new Thread(futureTask1);
        thread.start();
    }

    private void lick() {
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
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }


}
