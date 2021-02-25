package com.company.java.designmode.proxy.staticproxy;

public class SexProxy implements SexSubject {
    private final SexSubject mReal;

    public SexProxy(SexSubject pReal) {
        mReal = pReal;
    }

    @Override
    public void fuck() {
        mReal.fuck();
    }
}
