package com.company.java.concur.innerlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncChunkTest {


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
    public void die4() {
        String str="abc";
        synchronized (str) {
            System.out.println("die");
        }
    }
    public void die5() {
        synchronized ("abc") {
            System.out.println("die");
        }
    }
}
