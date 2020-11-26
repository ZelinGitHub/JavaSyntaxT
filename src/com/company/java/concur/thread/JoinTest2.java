package com.company.java.concur.thread;

public class JoinTest2 {
    public static void test() {
        try {

            Thread threadB = new Thread() {
                @Override
                public void run() {
                    super.run();
                    synchronized (this) {
                        try {
                            System.out.println("线程B：开始运行");
                            Thread.sleep(5000);
                            System.out.println("线程B：结束运行");
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                    }
                }
            };
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (threadB){
                        try {
                            System.out.println("线程A：开始运行");
                            Thread.sleep(5000);
                            System.out.println("线程A：结束运行");
                        } catch (InterruptedException pE) {
                            pE.printStackTrace();
                        }
                    }
                }
            });
            threadA.start();
            threadB.start();
            threadB.join(2000);
            System.out.println("主线程：结束运行");
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }
}
