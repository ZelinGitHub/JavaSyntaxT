package com.company.java.timedate;

import java.sql.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {
    public static void test() {
        LocalDate today = LocalDate.now();
        LocalDate hitlerBirthday = LocalDate.of(1889, 4, 20);
        hitlerBirthday = LocalDate.of(1889, Month.APRIL, 20);

        LocalDate localDate1 = hitlerBirthday.plusDays(1);
        LocalDate localDate2 = hitlerBirthday.plusWeeks(1);
        LocalDate localDate3 = hitlerBirthday.plusMonths(1);
        LocalDate localDate4 = hitlerBirthday.plusYears(1);

        LocalDate localDate5 = hitlerBirthday.minusDays(1);
        LocalDate localDate6 = hitlerBirthday.minusWeeks(1);
        LocalDate localDate7 = hitlerBirthday.minusMonths(1);
        LocalDate localDate8 = hitlerBirthday.minusYears(1);

        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        LocalDate localDate9 = hitlerBirthday.plus(duration);
        LocalDate localDate10 = hitlerBirthday.minus(duration);
        Period period = Period.between(localDate9, localDate10);
        LocalDate localDate11 = hitlerBirthday.plus(period);
        LocalDate localDate12 = hitlerBirthday.minus(period);

        DayOfWeek dayOfWeekX = DayOfWeek.SATURDAY.plus(3);

        LocalDate day1 = hitlerBirthday.withDayOfMonth(20);
        LocalDate day2 = hitlerBirthday.withDayOfYear(100);
        LocalDate day3 = hitlerBirthday.withMonth(3);
        LocalDate day4 = hitlerBirthday.withYear(10);

        DayOfWeek dayOfWeek = hitlerBirthday.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();

        int dayOfMonth = hitlerBirthday.getDayOfMonth();
        int dayOfYear = hitlerBirthday.getDayOfYear();
        Month month = hitlerBirthday.getMonth();
        int monthValue = hitlerBirthday.getMonthValue();
        int year = hitlerBirthday.getYear();


        boolean isBefore = hitlerBirthday.isBefore(localDate4);

        boolean isAfter = hitlerBirthday.isAfter(localDate8);

        boolean isLeapYear = hitlerBirthday.isLeapYear();

        LocalDate localDateX = LocalDate.of(2016, 1, 31).plusMonths(1);
        LocalDate localDateY = LocalDate.of(2016, 3, 31).minusMonths(1);
    }


    public static void test2() {
        LocalDate localDate1 = LocalDate.of(2000, 2, 10);
        LocalDate localDate2 = LocalDate.of(2020, 3, 14);

        Period period1 = localDate1.until(localDate2);

        Period period2 = Period.ofYears(3);

        Period period3 = Period.of(3, 8, 1);
        LocalDate independenceDay = LocalDate.of(2020, 7, 4);
        LocalDate christmas = LocalDate.of(2020, 12, 25);
        Period periodX = independenceDay.until(christmas);
        long days = independenceDay.until(christmas, ChronoUnit.DAYS);
    }

    public static void test3() {
        MonthDay monthDay = MonthDay.of(3, 12);
        YearMonth yearMonth = YearMonth.of(1911, 10);
        Year year = Year.of(1933);
    }

    public static void test4() {
        LocalDate localDate = LocalDate.of(2012, 4, 1);
        LocalDate firstTuesday = localDate
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));


        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate previousMonday = localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));

        LocalDate nextOrThisMonday = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate previousOrThisMonday = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));


        LocalDate dayOfWeekInMonth=localDate.with(TemporalAdjusters.dayOfWeekInMonth(2,DayOfWeek.MONDAY));
        LocalDate lastInMonth=localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));

        LocalDate firstDayOfMonth=localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstDayOfNextMonth=localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate lastDayOfMonth=localDate.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate firstDayOfNextYear=localDate.with(TemporalAdjusters.firstDayOfNextYear());
        LocalDate lastDayOfYear=localDate.with(TemporalAdjusters.lastDayOfYear());
    }

    public static void test5(){
        LocalDate localDate=LocalDate.now();
        java.sql.Date date=java.sql.Date.valueOf(localDate);
        localDate=date.toLocalDate();
    }
}
