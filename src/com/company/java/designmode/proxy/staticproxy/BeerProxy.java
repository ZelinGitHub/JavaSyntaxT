package com.company.java.designmode.proxy.staticproxy;

public class BeerProxy implements BeerSubject {
    private final BeerSubject mReal;

    public BeerProxy(BeerSubject pReal) {
        mReal = pReal;
    }

    @Override
    public void drink() {
        mReal.drink();
    }
}
