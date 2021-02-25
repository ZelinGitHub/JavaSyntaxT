package com.company.java.designmode.proxy.staticproxy;

public class FoodProxy implements FoodSubject {
    private final FoodSubject mReal;

    public FoodProxy(FoodSubject pReal) {
        mReal = pReal;
    }

    @Override
    public void eat() {
        mReal.eat();
    }
}
