package com.company.java.concur.timer;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSimpleOnOnceTest {
    //Timer安排一个任务
    public static void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().plusSeconds(10);
        Timer timer = new Timer("线程1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant));
    }

    //Timer安排一个任务，但使用守护线程
    //如果没有非守护线程存活，Timer的线程会自动终止，任务也就不会执行了
    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().plusSeconds(10);

        //设置Timer的线程为守护线程
        Timer timer = new Timer("线程1", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant));
    }

    //安排一个任务，任务执行时间早于当前时间
    //如果任务执行时间，早于当前时间，则立即执行任务
    public static void test3() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.minusSeconds(10).format(dateTimeFormatter)
        );
        Instant instant = Instant.now().minusSeconds(10);

        Timer timer = new Timer("线程1", false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalTime localTime = LocalTime.now();
                System.out.println("线程1：执行任务，当前时间为"
                        + localTime.format(dateTimeFormatter)
                );
            }
        }, Date.from(instant));
    }

    //Timer安排多个任务
    //任务串行执行，所以只有第一个任务的执行时间是和计划一致的
    // 其他任务的执行时间，可能因为前面任务的执行时间太长，而延后
    public static void test4() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("主线程：当前时间为"
                + localTime.format(dateTimeFormatter)
                +"，计划任务执行时间为"
                +localTime.plusSeconds(10).format(dateTimeFormatter)
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
    }
}
