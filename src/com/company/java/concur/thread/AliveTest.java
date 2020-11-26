package com.company.java.concur.thread;

public class AliveTest {

    public static void test() {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long threadId = Thread.currentThread().getId();
                        System.out.println("线程" + threadId + "：isAlive属性是" + Thread.currentThread().isAlive());
                        System.out.println("线程" + threadId + "：准备阻塞");
                        Thread.sleep(2000);
                        System.out.println("线程" + threadId + "：执行结束");
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                }
            });
            System.out.println("主线程：线程" + thread.getId() + "创建成功");
            System.out.println("线程" + thread.getId() + "：isAlive属性是" + thread.isAlive());
            System.out.println("主线程：启动线程" + thread.getId());
            thread.start();
            Thread.sleep(1000);
            System.out.println("主线程：线程" + thread.getId() + "的isAlive属性是" + thread.isAlive());
            Thread.sleep(2000);
            System.out.println("主线程：线程" + thread.getId() + "的isAlive属性是" + thread.isAlive());
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }
}
