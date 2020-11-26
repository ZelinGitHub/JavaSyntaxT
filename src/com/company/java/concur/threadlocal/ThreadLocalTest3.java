package com.company.java.concur.threadlocal;

public class ThreadLocalTest3 {
    private final MyThreadLocal mMyThreadLocal = new MyThreadLocal();

    public void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(mMyThreadLocal.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(mMyThreadLocal.get());
            }
        }).start();
        System.out.println(mMyThreadLocal.get());
    }

    static class MyThreadLocal extends ThreadLocal<String> {
        @Override
        protected String initialValue() {
            return "fuck u";
        }
    }

    public static void test() {
        ThreadLocalTest3 threadLocalTest3 = new ThreadLocalTest3();
        threadLocalTest3.fuck();
    }
}
