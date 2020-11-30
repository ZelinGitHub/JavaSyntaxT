package com.company.java.concur.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCancelTest {
    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    //TimerTask的cancel方法，将自己从Timer的任务队列中删除
    //因为任务被删除了，所以不会再按周期执行
    public static void test1() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);
        long periodMillis = 4000;

        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
                System.out.println("线程1：当前任务准备把自己删除掉");
                cancel();
            }
        }, date, periodMillis);
    }


    //Timer安排多个任务
    //任务在计划时间执行，之后每4s执行一次
    //Timer的cancel方法会删除Timer任务队列中的所有任务，清空任务队列
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

        try {
            Thread.sleep(10000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        timer.cancel();
    }
}
