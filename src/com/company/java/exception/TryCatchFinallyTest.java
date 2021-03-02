package com.company.java.exception;

public class TryCatchFinallyTest {
    public void tryFinally() {
        try {
            System.out.println("我是try");
        } finally {
            System.out.println("我是finally");
        }
    }

    public void tryCatchFinally() {
        try {
            System.out.println("我是try");
            throw new Exception("异常X");
        } catch (Exception pE) {
            System.out.println("我是catch");
        } finally {
            System.out.println("我是finally");
        }
    }

    public void tryFinallyTryCatch() {
        try {
            System.out.println("我是try1");
            try {
                System.out.println("我是try2");
                throw new Exception("异常X");
            } finally {
                System.out.println("我是finally");
            }
        } catch (Exception pE) {
            System.out.println("我是catch");
        }
    }


    public static void test(){
        TryCatchFinallyTest tryCatchFinallyTest=new TryCatchFinallyTest();
        tryCatchFinallyTest.tryFinallyTryCatch();
    }
}
