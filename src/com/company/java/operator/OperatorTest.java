package com.company.java.operator;

public class OperatorTest {
    public static void test() {
        int a = 0;
        int b = 0;
        int c = 0;
        a = b = c = 5;
        System.out.println("a=" + a + "," + "b=" + b + "," + "c=" + c);
        System.out.println();
    }

    public static void test2() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = (a = b = c = 5);
        System.out.println("d=" + d);
    }
}
