package com.company.java.concur.threadlocal;

public class InheritableThreadLocalTest2 {
    private final MyInheritableThreadLocal mInheritableThreadLocal = new MyInheritableThreadLocal();

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

    static class MyInheritableThreadLocal extends InheritableThreadLocal<String> {
        @Override
        protected String childValue(String parentValue) {
            return "新" + parentValue;
        }
    }

    public static void test() {
        InheritableThreadLocalTest2 inheritableThreadLocalTest2 = new InheritableThreadLocalTest2();
        inheritableThreadLocalTest2.fuck();
    }
}
