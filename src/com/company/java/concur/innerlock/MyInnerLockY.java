package com.company.java.concur.innerlock;

public class MyInnerLockY {
    private boolean done;

    public synchronized boolean isDone() {
        return done;
    }

    public synchronized void setDone() {
        done = true;
    }

}
