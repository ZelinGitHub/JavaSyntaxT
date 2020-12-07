package com.company.java.designmode.sington;

public class SingletonTest {

    public static void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        System.out.println("线程"+Thread.currentThread().getId()
                                +"：得到单例"
                                +DCLazySingleton.getInstance().hashCode()
                        );
                }
            }).start();
        }
    }
}
