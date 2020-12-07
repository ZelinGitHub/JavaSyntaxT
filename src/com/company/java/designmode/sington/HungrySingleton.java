package com.company.java.designmode.sington;

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
    public static HungrySingleton getInstance2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        return instance;
    }
}
