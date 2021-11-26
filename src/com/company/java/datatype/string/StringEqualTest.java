package com.company.java.datatype.string;

public class StringEqualTest {

    public static void testStringEqual() {
        testStringEqual_();
    }


    public static void testStringEqual_() {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println("str1 ==  \"Hello\": " + (str1 == "Hello"));
        System.out.println("str1 == str2 : " + (str1 == str2));
    }


}
