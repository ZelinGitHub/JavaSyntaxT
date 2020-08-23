package com.company.concur;

public class YieldTest {
    public static void test(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.yield();
            }
        });

        thread.start();
    }
}
