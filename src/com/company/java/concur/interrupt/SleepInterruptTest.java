package com.company.java.concur.interrupt;

public class SleepInterruptTest {


    private static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("线程开始执行");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程执行结束");
                    }
                });
                thread.start();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("中断前");
                thread.interrupt();
                System.out.println("中断后");
            }
        }).start();

    }
}
