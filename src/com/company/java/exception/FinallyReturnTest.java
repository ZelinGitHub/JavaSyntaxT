package com.company.java.exception;

public class FinallyReturnTest {

    public void tryReturnFinally() {
        try {
            System.out.println("我是try");
            return;
        } finally {
            System.out.println("我是finally");
        }
    }

    public void tryReturnFinallyReturn() {
        System.out.println(tryReturnFinallyReturn_());
    }

    public String tryReturnFinallyReturn_() {
        try {
            System.out.println("return try");
            return "try";
        } finally {
            System.out.println("return finally");
            return "finally";
        }
    }



    public static void test() {
        FinallyReturnTest finallyTest = new FinallyReturnTest();
        finallyTest.tryReturnFinallyReturn();
    }
}
