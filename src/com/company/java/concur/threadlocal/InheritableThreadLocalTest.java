package com.company.java.concur.threadlocal;

public class InheritableThreadLocalTest {
    private final InheritableThreadLocal<String> mInheritableThreadLocal = new InheritableThreadLocal<>();

    private void fuck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mInheritableThreadLocal.set("畜生");
                System.out.println("父线程：" + mInheritableThreadLocal.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("子线程：" + mInheritableThreadLocal.get());
                    }
                }).start();
            }
        }).start();
    }

    public static void test() {
        InheritableThreadLocalTest inheritableThreadLocalTest = new InheritableThreadLocalTest();
        inheritableThreadLocalTest.fuck();
    }
}
