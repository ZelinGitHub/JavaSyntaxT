package com.company.java.concur.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InnerClsMethodTest {
    public synchronized void kill() {
        System.out.println("kill");
    }

    public static synchronized void kill3() {
        System.out.println("kill");
    }

    public void kill2() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("kill");
        } finally {
            lock.unlock();
        }
    }
}
