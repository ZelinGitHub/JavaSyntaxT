package com.company.java.concur.innerlock;

public class SyncChunkTestReturn {
    public void fuck(boolean isReturn) {
        synchronized (this) {
            System.out.println("线程" + Thread.currentThread().getId() + "：0");
            System.out.println("线程" + Thread.currentThread().getId() + "：1");
            System.out.println("线程" + Thread.currentThread().getId() + "：2");
            if(isReturn){
                return;
            }
            System.out.println("线程" + Thread.currentThread().getId() + "：3");
            System.out.println("线程" + Thread.currentThread().getId() + "：4");
            System.out.println("线程" + Thread.currentThread().getId() + "：5");
        }
    }

    public void lick() {
        synchronized (this) {
            System.out.println("线程" + Thread.currentThread().getId() + "：0");
            System.out.println("线程" + Thread.currentThread().getId() + "：1");
            System.out.println("线程" + Thread.currentThread().getId() + "：2");
            System.out.println("线程" + Thread.currentThread().getId() + "：3");
            System.out.println("线程" + Thread.currentThread().getId() + "：4");
            System.out.println("线程" + Thread.currentThread().getId() + "：5");
        }
    }

    public static void test() {
        SyncChunkTestReturn syncChunkTestReturn = new SyncChunkTestReturn();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncChunkTestReturn.fuck(true);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    syncChunkTestReturn.lick();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
