package com.company.java.exception;

public class ThrowFinallyTest {
    public void tryThrowFinally() {
        try {
            tryThrowFinally_();
        } catch (Exception pE) {
            pE.printStackTrace();
            System.out.println("no fuck");
        }
    }

    private void tryThrowFinally_() throws Exception {
        try {
            throw new Exception("die");
        } finally {
            System.out.println("good die");
        }
    }



    public void tryTryThrowFinallyFinally() {
        try {
            tryTryThrowFinallyFinally_();
        } catch (Exception pE) {
            pE.printStackTrace();
        }
    }

    private void tryTryThrowFinallyFinally_() throws Exception {
        try {
            try {
                throw new Exception("die");
            } finally {
                System.out.println("good die");
            }
        } finally {
            System.out.println("bad die");
        }
    }
}
