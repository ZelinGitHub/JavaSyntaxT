package com.company.java.concur.threadcom.innercon;

public class ProConTest {
    private String mData="";

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


    }
}
