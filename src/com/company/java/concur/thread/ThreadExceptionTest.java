package com.company.java.concur.thread;

public class ThreadExceptionTest {
    public static void test1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：准备发生异常");
                int a = 3 / 0;
            }
        });
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：线程" + t.getId()
                        + "发生异常" + e.getLocalizedMessage());
            }
        });
        thread1.start();
    }

    public static void test2() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：准备发生异常");
                int a = 3 / 0;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：准备发生异常");
                int a = 3 / 0;
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：线程" + t.getId()
                        + "发生异常" + e.getLocalizedMessage());
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void test3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：准备发生异常");
                int a = 3 / 0;
            }
        });

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：线程" + t.getId()
                        + "发生异常" + e.getLocalizedMessage()
                        +"（默认异常处理器）"
                );
            }
        });

        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：线程" + t.getId()
                        + "发生异常" + e.getLocalizedMessage()
                        +"（单独的异常处理器）"
                );
            }
        });
        thread1.start();
    }
}
