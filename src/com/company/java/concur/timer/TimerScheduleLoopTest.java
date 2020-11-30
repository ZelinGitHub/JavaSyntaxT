package com.company.java.concur.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduleLoopTest {

    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    public static void test1() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        long periodMillis = 4000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date, periodMillis);
    }

    //Timer安排多个任务
    //任务在计划时间执行，之后每4s执行一次
    public static void test2() {
        Date date1 = new Date();
        System.out.println("主线程：任务计划执行时间为" + date1);

        Date date2 = new Date();
        System.out.println("主线程：任务计划执行时间为" + date2);

        long periodMillis = 4000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date1, periodMillis);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, date2, periodMillis);
    }

    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    //如果任务执行时间超过执行周期，将按照任务执行时间作为执行周期
    public static void test3() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        long periodMillis = 4000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, date, periodMillis);
    }
}
