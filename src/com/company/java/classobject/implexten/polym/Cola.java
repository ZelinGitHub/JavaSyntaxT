package com.company.java.classobject.implexten.polym;

public class Cola extends Drink{
    public int a=200;

    public void kc(){
        System.out.println(super.a);
        System.out.println(a);
    }
}
