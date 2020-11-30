package com.company.java.concur.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduleOnceTest {
    //Timer安排一个任务
    public static void test() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date);
    }

    //Timer安排一个任务，但使用守护线程
    //如果没有非守护线程存活，Timer的线程会自动终止，任务也就不会执行了
    public static void test2() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        //设置Timer的线程为守护线程
        Timer timer = new Timer("线程1", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date);
    }
    //安排一个任务，任务执行时间早于当前时间
    //如果任务执行时间，早于当前时间，则立即执行任务
    public static void test3() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        Timer timer = new Timer("线程1", false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date);
    }

    //Timer安排多个任务
    //任务串行执行，所以只有第一个任务的执行时间是和计划一致的
    // 其他任务的执行时间，可能因为前面任务的执行时间太长，而延后
    public static void test4() {
        Date date1 = new Date();
        System.out.println("主线程：任务1计划执行时间为" + date1);

        Date date2 = new Date();
        System.out.println("主线程：任务2计划执行时间为" + date2);

        Date date3 = new Date();
        System.out.println("主线程：任务3计划执行时间为" + date3);

        Timer timer = new Timer("线程1", false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务1，当前时间为" + new Date());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, date1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务2，当前时间为" + new Date());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, date2);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务3，当前时间为" + new Date());
            }
        }, date3);
    }
}
