package com.company.java.concur.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InnerClsCodeChunkTest {


    public void die() {
        Object object = new Object();
        synchronized (object) {
            System.out.println("die");
        }
    }
    public void die2() {
        synchronized (this) {
            System.out.println("die");
        }
    }
    public void die3() {
        synchronized (String.class) {
            System.out.println("die");
        }
    }
}
