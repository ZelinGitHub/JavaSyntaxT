package com.company.java.designmode.proxy.staticproxy;

public class Guy implements SexSubject, FoodSubject, BeerSubject {
    @Override
    public void drink() {
        System.out.println("Guy drink");
    }

    @Override
    public void eat() {
        System.out.println("Guy eat");
    }

    @Override
    public void fuck() {
        System.out.println("Guy fuck");
    }
}
