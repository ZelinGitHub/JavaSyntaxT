package com.company.java.timedate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LocalDateTimeTest {
    public static void test(){
        LocalDateTime localDateTime= LocalDateTime.now();
        Timestamp timestamp=Timestamp.valueOf(localDateTime);

        localDateTime=timestamp.toLocalDateTime();
    }
}
