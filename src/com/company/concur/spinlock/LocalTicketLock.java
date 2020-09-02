package com.company.concur.spinlock;

import java.util.concurrent.atomic.AtomicInteger;

public class LocalTicketLock {
    private AtomicInteger mServiceNum = new AtomicInteger();

    private AtomicInteger mTicketNum = new AtomicInteger();

    private ThreadLocal<Integer> mThreadLocal = new ThreadLocal<>();

    public int lock() {
        int currentTicketNum = mTicketNum.getAndIncrement();
        mThreadLocal.set(currentTicketNum);
        while (currentTicketNum != mServiceNum.get()) {
        }
        return currentTicketNum;
    }

    public void unlock() {
        int ticketNum=mThreadLocal.get();
        mServiceNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
