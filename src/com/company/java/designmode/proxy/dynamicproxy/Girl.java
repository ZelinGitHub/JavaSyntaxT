package com.company.java.designmode.proxy.dynamicproxy;

public class Girl implements ChestSubject,AssSubject,PussySubject {
    @Override
    public void lick() {
        System.out.println("Girl lick");
    }

    @Override
    public void grab() {
        System.out.println("Girl grab");
    }

    @Override
    public void insert() {
        System.out.println("Girl insert");
    }
}
