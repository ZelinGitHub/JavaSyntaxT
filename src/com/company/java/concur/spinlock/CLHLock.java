package com.company.java.concur.spinlock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CLHLock {
    public static class CLHNode {
        private volatile boolean isActive = true;
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
        CLHNode node = THREAD_LOCAL.get();
        if (node == null) {
            node = new CLHNode();
            THREAD_LOCAL.set(node);
        }
        CLHNode preNode = (CLHNode) UPDATER.getAndSet(this, node);
        if (preNode != null) {
            while (preNode.isActive) {
            }
        }
    }

    public void unlock() {
        CLHNode node = THREAD_LOCAL.get();
        if (node != null && node.isActive) {
            if (!UPDATER.compareAndSet(this, node, null)) {
                node.isActive = false;
            }
            THREAD_LOCAL.remove();
        }
    }
}


