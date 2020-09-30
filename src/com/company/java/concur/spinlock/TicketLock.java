package com.company.java.concur.spinlock;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    private AtomicInteger mServiceNum = new AtomicInteger(0);

    private AtomicInteger mTicketNum = new AtomicInteger(0);

    public int lock() {
        int currentTicketNum = mTicketNum.getAndIncrement();
        while (currentTicketNum != mServiceNum.get()) {
        }
        return currentTicketNum;
    }

    public void unlock(int ticketNum) {
        mServiceNum.compareAndSet(ticketNum, mServiceNum.get()+1);
    }
}
