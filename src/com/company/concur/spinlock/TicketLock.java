package com.company.concur.spinlock;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    private AtomicInteger mServiceNum = new AtomicInteger();

    private AtomicInteger mTicketNum = new AtomicInteger();

    public int lock() {
        int currentTicketNum = mTicketNum.getAndIncrement();
        while (currentTicketNum != mServiceNum.get()) {
        }
        return currentTicketNum;
    }

    public void unlock(int ticketNum) {
        mServiceNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
