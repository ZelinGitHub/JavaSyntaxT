package com.company.java.concur.vol;

public class VolatileTest {
    private volatile boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }
}
