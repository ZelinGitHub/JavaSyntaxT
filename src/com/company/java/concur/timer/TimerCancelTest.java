package com.company.java.concur.timer;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCancelTest {
    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    //TimerTask的cancel方法，将自己从Timer的任务队列中删除
    //因为任务被删除了，所以不会再按周期执行
    public static void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                + "，计划任务执行时间为"
                + localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().plusSeconds(10);
        long periodMillis = 4000;

        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
                System.out.println("线程1：取消当前任务");
                cancel();
            }
        }, Date.from(instant), periodMillis);
    }


    //Timer安排多个任务
    //任务在计划时间执行，之后每4s执行一次
    //Timer的cancel方法会删除Timer任务队列中的所有任务，清空任务队列
    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                + "，计划任务执行时间为"
                + localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant1 = Instant.now().plusSeconds(10);
        Instant instant2 = instant1.plusSeconds(10);
        Instant instant3 = instant2.plusSeconds(10);
        Timer timer = new Timer("线程1", false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务1，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, Date.from(instant1));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务2，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, Date.from(instant2));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务3，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant3));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        timer.cancel();
    }
}
