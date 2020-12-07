package com.company.java.designmode.sington;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstance2() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}
