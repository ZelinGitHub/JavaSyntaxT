package com.company.java.timedate;

import java.time.Duration;
import java.time.Instant;

public class TimeLineTest {
    public static void test() {
        Instant instant = Instant.now();
    }

    public static void test2() {
        Instant start = Instant.now();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        long nanos = timeElapsed.toNanos();
        long millis = timeElapsed.toMillis();
        long seconds = timeElapsed.toSeconds();

        System.out.println("时间段的纳秒数为" + nanos);
        System.out.println("时间段的毫秒数为" + millis);
        System.out.println("时间段的秒数为" + seconds);
    }
}
