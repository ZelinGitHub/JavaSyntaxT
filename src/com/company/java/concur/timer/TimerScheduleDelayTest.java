package com.company.java.concur.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduleDelayTest {

    //以当前的时间为参考，在此时间基础上，延迟指定的毫秒数后，执行任务
    public static void test1() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, 3000);
    }
    //以当前的时间为参考，在此时间基础上，延迟指定的毫秒数后，执行任务
    //然后再以某一个间隔时间，无限次数地执行任务
    public static void test2() {
        Date date = new Date();
        System.out.println("主线程：任务计划执行时间为" + date);

        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程1：执行任务，当前时间为" + new Date());
            }
        }, 3000);
    }
}
