package com.company.concur.spinlock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class MCSLock {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isNoLockFuck = true;
    }
    private static final ThreadLocal<MCSNode> THREAD_LOCAL = new ThreadLocal<>();
    private volatile MCSNode mQueue;
    private static final AtomicReferenceFieldUpdater UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(
            MCSLock.class
            , MCSNode.class
            , "mQueue"
    );
    public void lock() {
        MCSNode node = new MCSNode();
        THREAD_LOCAL.set(node);
        MCSNode preNode = (MCSNode) UPDATER.getAndSet(this, node);
        if (preNode != null) {
            preNode.next = node;
            while (node.isNoLockFuck) {
            }
        }
    }
    public void unlock() {
        MCSNode node = (MCSNode) THREAD_LOCAL.get();
        if (node.next == null) {
            if (UPDATER.compareAndSet(this, node, null)) {
                return;
            } else {
                while (node.next == null) {
                }
            }
        } else {
            node.next.isNoLockFuck = false;
            node.next = null;
        }
    }
}
