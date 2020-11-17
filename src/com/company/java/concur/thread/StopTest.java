package com.company.java.concur.thread;

public class StopTest {
    public static void test(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        thread.start();
        thread.stop();
    }
}
