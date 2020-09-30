package com.company.java.concur.spinlock;

import java.util.concurrent.atomic.AtomicReference;

public class ReentrantSpinLock {
    private AtomicReference<Object> mAtomicReference = new AtomicReference<>();
    private int count;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == mAtomicReference.get()) {
            count++;
            return;
        }
        while (!mAtomicReference.compareAndSet(null, currentThread)) {
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == mAtomicReference.get()) {
            if (count > 0) {
                count--;
            } else {
                mAtomicReference.compareAndSet(currentThread, null);
            }
        }
    }
}
