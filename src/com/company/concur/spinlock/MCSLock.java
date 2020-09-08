package com.company.concur.spinlock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class MCSLock {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean hasNoLock = true;
    }

    private static final ThreadLocal<MCSNode> THREAD_LOCAL = new ThreadLocal<>();
    private volatile MCSNode mNode;
    private static final AtomicReferenceFieldUpdater UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(
            MCSLock.class
            , MCSNode.class
            , "mNode"
    );

    public void lock() {
        MCSNode node = THREAD_LOCAL.get();
        if (node == null) {
            node = new MCSNode();
            THREAD_LOCAL.set(node);
        }

        MCSNode preNode = (MCSNode) UPDATER.getAndSet(this, node);
        if (preNode != null) {
            preNode.next = node;
            while (node.hasNoLock) {
            }
        }
    }

    public void unlock() {
        MCSNode node = (MCSNode) THREAD_LOCAL.get();
        if (node != null && !node.hasNoLock) {
            if (node.next == null) {
                if (!UPDATER.compareAndSet(this, node, null)) {
                    while (node.next == null) {
                    }
                }
            }
            if(node.next!=null) {
                node.next.hasNoLock = false;
                node.next = null;
            }
            THREAD_LOCAL.remove();
        }
    }
}
