package com.company.java.concur.spinlock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    private AtomicReference<Object> mAtomicReference = new AtomicReference<>();
    public void lock(){
        Thread currentThread=Thread.currentThread();
        while(!mAtomicReference.compareAndSet(null,currentThread)){
        }
    }

    public void unlock(){
        Thread currentThread=Thread.currentThread();
        mAtomicReference.compareAndSet(currentThread,null);
    }
}
