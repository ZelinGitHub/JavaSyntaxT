package com.company.java.concur.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDateFormatTest {
    public static void test1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateArray = {
                "2000-01-01"
                , "2000-01-02"
                , "2000-01-03"
                , "2000-01-04"
                , "2000-01-05"
                , "2000-01-06"
                , "2000-01-07"
                , "2000-01-08"
                , "2000-01-09"
                , "2000-01-10"
        };
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //Date是时间点
                        Date date = sdf.parse(dateArray[index]);
                        String dateStr = sdf.format(date);
                        System.out.println("线程" + Thread.currentThread().getId() + "：日期是" + dateStr);
                    } catch (ParseException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void test2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateArray = {
                "2000-01-01"
                , "2000-01-02"
                , "2000-01-03"
                , "2000-01-04"
                , "2000-01-05"
                , "2000-01-06"
                , "2000-01-07"
                , "2000-01-08"
                , "2000-01-09"
                , "2000-01-10"
        };
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //Date是时间点
                        Date date = sdf.parse(dateArray[index]);
                        String dateStr = sdf.format(date);
                        System.out.println("线程" + Thread.currentThread().getId() + "：日期是" + dateStr);
                    } catch (ParseException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void test3() {
        String[] dateArray = {
                "2000-01-01"
                , "2000-01-02"
                , "2000-01-03"
                , "2000-01-04"
                , "2000-01-05"
                , "2000-01-06"
                , "2000-01-07"
                , "2000-01-08"
                , "2000-01-09"
                , "2000-01-10"
        };
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        //Date是时间点
                        Date date = sdf.parse(dateArray[index]);
                        String dateStr = sdf.format(date);
                        System.out.println("线程" + Thread.currentThread().getId() + "：日期是" + dateStr);
                    } catch (ParseException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void test4() {
        ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
        String[] dateArray = {
                "2000-01-01"
                , "2000-01-02"
                , "2000-01-03"
                , "2000-01-04"
                , "2000-01-05"
                , "2000-01-06"
                , "2000-01-07"
                , "2000-01-08"
                , "2000-01-09"
                , "2000-01-10"
        };
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        SimpleDateFormat sdf = threadLocal.get();
                        if (sdf == null) {
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                            threadLocal.set(sdf);
                        }
                        //Date是时间点
                        Date date = sdf.parse(dateArray[index]);
                        String dateStr = sdf.format(date);
                        System.out.println("线程" + Thread.currentThread().getId() + "：日期是" + dateStr);
                    } catch (ParseException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
