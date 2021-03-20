package com.company.java.classobject.implexten.overridetest;

public class CocaCola extends Coke{
    @Override
    protected void boom(){
        super.boom();
        System.out.println("CocaCola boom");
    }

    @Override
    protected void spill(){
        System.out.println("CocaCola spill");
    }
}
