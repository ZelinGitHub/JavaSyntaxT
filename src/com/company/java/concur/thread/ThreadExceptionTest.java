package com.company.java.concur.thread;

public class ThreadExceptionTest {
    public static void testThreadException() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：开始执行");
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long threadId = Thread.currentThread().getId();
                        System.out.println("线程" + threadId + "：开始执行");
                        System.out.println("线程" + threadId + "：准备发生异常");
                        int a = 3 / 0;
                        System.out.println("线程" + threadId + "：执行结束");
                    }
                });
                System.out.println("线程" + threadId + "：开启新线程");
                thread1.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
                System.out.println("线程" + threadId + "：执行结束");
            }
        }).start();
    }

    public static void testUncaughtExceptionHandler() {
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

    public static void testDefaultUncaughtExceptionHandler() {
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

    public static void testDefaultAndNotDefaultUncaughtExceptionHandler() {
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
                        + "（默认异常处理器）"
                );
            }
        });

        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程" + threadId + "：线程" + t.getId()
                        + "发生异常" + e.getLocalizedMessage()
                        + "（单独的异常处理器）"
                );
            }
        });
        thread1.start();
    }
}
