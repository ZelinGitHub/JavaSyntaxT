package com.company.concur;

public class RunnableTest {

    private static void testRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是Runnable");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void testRunnable2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("我是任务逻辑");
            }
        };
        thread.start();
    }


}
