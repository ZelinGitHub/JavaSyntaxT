package com.company.java.concur.timer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSimpleDelayTest {

    //以当前的时间为参考，在此时间基础上，延迟指定的毫秒数后，执行任务
    public static void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, 10000);
    }

    //以当前的时间为参考，在此时间基础上，延迟指定的毫秒数后，执行任务
    //然后再以某一个间隔时间，无限次数地执行任务
    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, 10000,3000);
    }
}
