package com.company.java.timedate;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ZonedDateTimeTest {
    public static void test(){
        ZonedDateTime zonedDateTime=ZonedDateTime.now();

        GregorianCalendar gregorianCalendar=GregorianCalendar.from(zonedDateTime);

        zonedDateTime=gregorianCalendar.toZonedDateTime();
    }
}
