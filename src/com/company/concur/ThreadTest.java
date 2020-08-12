package com.company.concur;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void test() {
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(callable);

        MyRunnable myRunnable = new MyRunnable();
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable, "成功");

        Thread thread = new Thread(futureTask);
        thread.start();

        Thread curThread = Thread.currentThread();
        boolean isInterrupted = curThread.isInterrupted();

        boolean isInterruptedX = Thread.interrupted();

        Thread.State state=thread.getState();

        curThread.interrupt();
    }
}
