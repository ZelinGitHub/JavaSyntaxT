package com.company.java.designmode.sington;

public class StaticInnerSingleton {
    private StaticInnerSingleton() {
    }

    private static class Holder {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return Holder.instance;
    }
}
