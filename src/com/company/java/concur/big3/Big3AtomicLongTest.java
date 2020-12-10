package com.company.java.concur.big3;

public class Big3AtomicLongTest {
    private static long mLong=0;

    public static void test(){
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    mLong=123456789;
                }
            }).start();
        }
        for (int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println(mLong);
                }
            }).start();
        }
    }
}
