package com.company.java.concur.thread;

public class DaemonTest {
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (true) {
                        i++;
                        System.out.println("守护线程Jack： 我殴打主线程" + i+"次");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(5000);
            System.out.println("主线程：我终止了，Jack不再殴打我");
        } catch (InterruptedException pE) {
            pE.printStackTrace();
            //消除低层次中断异常捕获
            Thread.currentThread().interrupt();
        }
    }
}
