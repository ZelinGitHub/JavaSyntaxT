package com.company.java.timedate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeFormatterTest {

    //使用系统格式化器
    public static void test1(){
        LocalDate localDate=LocalDate.now();
        String formatted= DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(localDate);
    }

    //使用Locale相关的格式化器
    public static void test2(){
        LocalDate localDate=LocalDate.now();

        DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String formatted=formatter.format(localDate);

        formatted=formatter.withLocale(Locale.FRENCH).format(localDate);

        for(DayOfWeek week:DayOfWeek.values()){
            System.out.println(week.getDisplayName(TextStyle.SHORT,Locale.ENGLISH));
        }
    }

    //使用自定义格式的格式化器
    public static void test3(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
    }

    //解析字符串中的日期/时间值
    public static void test4(){
        //使用标准的ISO_LOCAL_DATE格式化器
        LocalDate churchsBirthday=LocalDate.parse("1903-06-14");

        //使用自定义格式的格式化器
        ZonedDateTime apollo11Launch=ZonedDateTime.parse(
                "1969-07-16 03:32:00-0400"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx")
        );
    }
}
