package com.company.java.concur.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    private String mData1 = "";
    private String mData2 = "";
    private String mData3 = "";

    private final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("三个线程都执行完成");
            System.out.println("线程1数据：" + mData1);
            System.out.println("线程2数据：" + mData2);
            System.out.println("线程3数据：" + mData3);
        }
    });

    public void test() {
        getData1();
        getData2();
        getData3();
    }


    private void getData1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(5));
                    mData1 = "AAA";
                    barrier.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }

    private void getData2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(5));
                    mData2 = "BBB";
                    barrier.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }

    private void getData3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(5));
                    mData3 = "CCC";
                    barrier.await();
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException pE) {
                    pE.printStackTrace();
                }
            }
        }).start();
    }
}
