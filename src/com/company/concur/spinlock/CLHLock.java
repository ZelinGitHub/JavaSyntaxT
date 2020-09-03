package com.company.concur.spinlock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CLHLock {
    public static class CLHNode {
        private volatile boolean isCurrentOrSomeonePreHaveLock = true;
    }
    private volatile CLHNode mTail;
    private static final ThreadLocal<CLHNode> THREAD_LOCAL = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(
            CLHLock.class
            , CLHNode.class,
            "mTail"
    );

    public void lock() {
        CLHNode node = new CLHNode();
        THREAD_LOCAL.set(node);
        CLHNode preNode = (CLHNode) UPDATER.getAndSet(this, node);
        if (preNode != null) {
            while (preNode.isCurrentOrSomeonePreHaveLock) {
            }
        }
    }

    public void unlock() {
        CLHNode node = THREAD_LOCAL.get();
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isCurrentOrSomeonePreHaveLock = false;
        }
    }
}


