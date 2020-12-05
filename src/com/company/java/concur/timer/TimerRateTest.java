package com.company.java.concur.timer;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerRateTest {
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
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant), periodMillis);
    }

    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Timer timer = new Timer("线程1");
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, 10000,3000);
    }

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
        timer.scheduleAtFixedRate(new TimerTask() {
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
        timer.scheduleAtFixedRate(new TimerTask() {
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
