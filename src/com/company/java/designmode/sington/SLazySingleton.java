package com.company.java.designmode.sington;

public class SLazySingleton {
    private static SLazySingleton instance;

    private SLazySingleton() {
    }

    public synchronized static SLazySingleton getInstance() {
        if (instance == null) {
            instance = new SLazySingleton();
        }
        return instance;
    }

    public synchronized static SLazySingleton getInstance2() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
            instance = new SLazySingleton();
        }
        return instance;
    }
}
