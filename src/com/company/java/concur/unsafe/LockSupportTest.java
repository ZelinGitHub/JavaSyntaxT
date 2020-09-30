package com.company.java.concur.unsafe;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void test(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是当前线程");

                LockSupport.park();

            }
        });

        thread.start();
    }
}
