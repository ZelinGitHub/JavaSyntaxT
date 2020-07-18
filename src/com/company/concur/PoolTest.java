package com.company.concur;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolTest {

    private static void testPool() {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(4);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadScheduledExecutor();
        Executor e;

        ThreadPoolExecutor threadPoolExecutor;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    }
}
