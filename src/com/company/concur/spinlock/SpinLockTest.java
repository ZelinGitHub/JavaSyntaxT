package com.company.concur.spinlock;

public class SpinLockTest {
    private static int sData = 0;

    public static void test() {
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

    public static void test4() {
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

    public static void test2() {
        SpinLock aSpinLock = new SpinLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aSpinLock.lock();
                    sData++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " 数据：" + sData);
                    aSpinLock.unLock();
                }
            }).start();
        }
    }

    public static void test3() {
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
                    aReentrantSpinLock.unLock();
                    aReentrantSpinLock.unLock();
                }
            }).start();
        }
    }
}
