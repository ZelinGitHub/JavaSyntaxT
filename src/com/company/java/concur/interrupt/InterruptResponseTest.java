package com.company.java.concur.interrupt;

public class InterruptResponseTest {


    //循环检测中断
    private static void testCycleInterruptCheck() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isInProgress = true;
                while (isInProgress) {
                    if (Thread.interrupted()) {
                        System.out.println("线程中断");
                        return;
                    }
                    System.out.println("我是正在运行的线程");
                }
            }
        });

        thread.start();
        thread.interrupt();
    }


    //循环捕获异常
    public static void testCycleExceptionCatch() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isInProgress = true;
                try {
                    while (isInProgress) {
                        System.out.println("我是正在运行的线程");
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("线程中断");
                } finally {
                }
            }
        });
        thread.start();
        thread.interrupt();
    }


}
