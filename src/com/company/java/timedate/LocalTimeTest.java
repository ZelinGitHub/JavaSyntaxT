package com.company.java.timedate;

import java.time.LocalTime;

public class LocalTimeTest {
    public static void test() {
        LocalTime rightNow = LocalTime.now();
        LocalTime bedtime = LocalTime.of(22, 30);
        LocalTime fuckTime = LocalTime.of(22, 31,22);
    }
}
