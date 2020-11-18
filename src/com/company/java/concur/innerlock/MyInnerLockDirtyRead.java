package com.company.java.concur.innerlock;

public class MyInnerLockDirtyRead {
    public String mNation = "美国";
    public String mCity = "旧金山";
    public synchronized void setValue(String pNation, String pCity) throws InterruptedException {
        mNation = pNation;
        Thread.sleep(3000);
        mCity = pCity;
    }

    public void getValue() {
        System.out.println("线程"+Thread.currentThread().getId()
                +"：国家-" + mNation+"，城市-" + mCity);
    }
    public synchronized void getValue2() {
        System.out.println("线程"+Thread.currentThread().getId()
                +"：国家-" + mNation+"，城市-" + mCity);
    }

    public static void test(){
        MyInnerLockDirtyRead myInnerLockDirtyRead=new MyInnerLockDirtyRead();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myInnerLockDirtyRead.getValue();
                    myInnerLockDirtyRead.setValue("荷兰","海牙");
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    myInnerLockDirtyRead.getValue2();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
