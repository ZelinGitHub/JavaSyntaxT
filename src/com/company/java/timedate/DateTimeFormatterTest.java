package com.company.java.timedate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void test(){
        LocalDate localDate=LocalDate.now();
        String formatted= DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(localDate);

    }
}
