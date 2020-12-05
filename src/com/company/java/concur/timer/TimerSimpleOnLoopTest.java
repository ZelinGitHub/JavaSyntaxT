package com.company.java.concur.timer;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSimpleOnLoopTest {

    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    public static void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
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
            }
        }, Date.from(instant), periodMillis);
    }

    //Timer安排多个任务
    //任务在计划时间执行，之后每4s执行一次
    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务1执行时间为"
                +localTime.plusSeconds(5).format(dateTimeFormatter)
                +"，计划任务2执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant1 = Instant.now().plusSeconds(5);
        Instant instant2 = Instant.now().plusSeconds(10);
        long periodMillis1 = 5000;
        long periodMillis2 = 10000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务1，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant1), periodMillis1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务2，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant2), periodMillis2);
    }

    //Timer安排一个任务
    //任务在计划时间执行，之后每4s执行一次
    //如果任务执行时间超过执行周期，将按照任务执行时间作为执行周期
    public static void test3() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().plusSeconds(10);

        long periodMillis = 4000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务1，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }
            }
        }, Date.from(instant), periodMillis);
    }

    public static void test4() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.minusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().minusSeconds(10);

        long periodMillis = 4000;
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant), periodMillis);
    }
}
