package com.company.java.designmode.sington;

public class VDCLazySingleton {
    private static volatile VDCLazySingleton instance;

    private VDCLazySingleton() {
    }

    public static VDCLazySingleton getInstance() {
        if(instance==null){
            synchronized (VDCLazySingleton.class){
                if (instance == null) {
                    instance = new VDCLazySingleton();
                }
            }
        }
        return instance;
    }
}
