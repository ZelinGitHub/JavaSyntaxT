package com.company.java.designmode.sington;

public class DCLazySingleton {
    private static DCLazySingleton instance;

    private DCLazySingleton() {
    }

    public static DCLazySingleton getInstance() {
        if(instance==null){
            synchronized (DCLazySingleton.class){
                if (instance == null) {
                    instance = new DCLazySingleton();
                }
            }
        }
        return instance;
    }
}
