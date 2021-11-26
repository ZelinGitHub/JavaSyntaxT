package com.company.java.datatype.string;

public class StringTest {

    public static void testStringEquals() {
        String str = new String("Hello");
        System.out.println(str.equals("Hello"));
        System.out.println("Hello".equals(str));
    }
    public static void testStringSubString() {
        String str1 = "Hello";
        String str6 = "Hellooo".substring(0, 5);
        String str7 = "Hello".substring(0, 5);
        System.out.println("str6=" + str6);
        System.out.println("str7=" + str7);
        System.out.println("str1 == str6 : " + (str1 == str6));
        System.out.println("str1 == str7 : " + (str1 == str7));
    }
}
