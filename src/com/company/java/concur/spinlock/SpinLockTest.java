package com.company.java.concur.spinlock;

public class SpinLockTest {
    private static int sData = 0;

    public static void testTicketLock() {
        TicketLock aTicketLock = new TicketLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int ticketNum = aTicketLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aTicketLock.unlock(ticketNum);
                }
            }).start();
        }
    }

    public static void testLocalTicketLock() {
        LocalTicketLock aTicketLock = new LocalTicketLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aTicketLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aTicketLock.unlock();
                }
            }).start();
        }
    }

    public static void testSpinLock() {
        SpinLock aSpinLock = new SpinLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aSpinLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aSpinLock.unlock();
                }
            }).start();
        }
    }

    public static void testReentrantSpinLock() {
        ReentrantSpinLock aReentrantSpinLock = new ReentrantSpinLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aReentrantSpinLock.lock();
                    sData++;
                    aReentrantSpinLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aReentrantSpinLock.unlock();
                    aReentrantSpinLock.unlock();
                }
            }).start();
        }
    }
    public static void testCLHLock() {
        CLHLock aCLHLock = new CLHLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aCLHLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aCLHLock.unlock();
                }
            }).start();
        }
    }
    public static void testMCSLock() {
        MCSLock mcsLock = new MCSLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mcsLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    mcsLock.unlock();
                }
            }).start();
        }
    }
}
