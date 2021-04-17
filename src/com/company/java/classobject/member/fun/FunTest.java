package com.company.java.classobject.member.fun;

import com.company.kotlin.clsobj.objectdeclare.B;

public class FunTest {

    public static void suckCup(Cup pCup) {
        System.out.println(pCup);
    }

    public static void fuckCup(Cup pCup) {
        System.out.println(pCup);
    }

    public static void fuckCup(BlueCup pBlueCup) {
        System.out.println(pBlueCup);
    }


    public void lickCup(Cup pCup) {
        System.out.println(pCup);
    }

    public void kickCup(Cup pCup) {
        System.out.println(pCup);
    }

    public void kickCup(BlueCup pBlueCup) {
        System.out.println(pBlueCup);
    }


    public static void test() {

        Cup cup = new Cup();
        BlueCup blueCup = new BlueCup();
        FunTest.suckCup(cup);
        FunTest.suckCup(blueCup);

        FunTest.fuckCup(cup);
        FunTest.fuckCup(blueCup);
    }
}
