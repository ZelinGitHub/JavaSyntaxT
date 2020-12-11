package com.company.java.concur.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolShutTest {
    public static void test(){

        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.shutdown();
        threadPool.shutdownNow();
    }
}
