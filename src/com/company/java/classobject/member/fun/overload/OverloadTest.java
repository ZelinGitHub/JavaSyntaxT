package com.company.java.classobject.member.fun.overload;

public class OverloadTest {


    public static void fuckCup(Cup pCup) {
        System.out.println(pCup);
    }

    public static void fuckCup(BlueCup pBlueCup) {
        System.out.println(pBlueCup);
    }



    public static void test() {

        Cup cup = new Cup();
        BlueCup blueCup = new BlueCup();
        BigBlueCup bigBlueCup=new BigBlueCup();

        //精准匹配fuckCup(Cup pCup)
        OverloadTest.fuckCup(cup);
        //模糊匹配fuckCup(Cup pCup)
        OverloadTest.fuckCup(blueCup);

        //精准匹配fuckCup(Cup pCup)
        OverloadTest.fuckCup(cup);
        //精准匹配fuckCup(BlueCup pBlueCup)，而不是fuckCup(Cup pCup)
        OverloadTest.fuckCup(blueCup);

        //模糊匹配fuckCup(BlueCup pBlueCup)，而不是fuckCup(Cup pCup)，因为BigBlueCup在继承关系上和BlueCup更近
        OverloadTest.fuckCup(bigBlueCup);


    }
}
