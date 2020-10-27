package com.company.java.concur.interrupt;

public class KillLowInterruptExceptCatch {
    void mySubTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    void mySubTask2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    void mySubTask3() throws InterruptedException {
        Thread.sleep(5000);
    }
}
