package com.company.java.concur.threadlocal;

public class ThreadLocalTest2 {
    private String mStr = "";

    private final ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();


    public void lick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        mStr = "线程1";
                        Thread.sleep(1000);
                        System.out.println("线程1：" + mStr);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        mStr = "线程2";
                        Thread.sleep(1000);
                        System.out.println("线程2：" + mStr);
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
        try {
            for (int i = 0; i < 5; i++) {
                mStr = "主线程";
                Thread.sleep(1000);
                System.out.println("主线程：" + mStr);
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        mStringThreadLocal.set("线程1");
                        Thread.sleep(1000);
                        System.out.println("线程1：" + mStringThreadLocal.get());
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        mStringThreadLocal.set("线程2");
                        Thread.sleep(1000);

                        System.out.println("线程2：" + mStringThreadLocal.get());
                    }
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
        try {
            for (int i = 0; i < 5; i++) {
                mStringThreadLocal.set("主线程");
                Thread.sleep(1000);
                System.out.println("主线程：" + mStringThreadLocal.get());
            }
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }


    public static void test() {
        ThreadLocalTest2 threadLocalTest2 = new ThreadLocalTest2();
        threadLocalTest2.lick();
    }

    public static void test2() {
        ThreadLocalTest2 threadLocalTest2 = new ThreadLocalTest2();
        threadLocalTest2.fuck();
    }
}
