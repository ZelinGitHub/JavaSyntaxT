package com.company.java.datatype.stringconst;

public class StringConstEqualTest {

    public static void testStringConstEqual() {
        System.out.println("\"Hello\"== \"Hello\" : " + ("Hello" == "Hello"));
        String str2 = "Hello";
        System.out.println("str2 == \"Hello\" : " + (str2 == "Hello"));
    }


    public static void testStringConstAddEqual() {
        String str1 = "Hello";
        String str2 = "Hel" + "lo";
        String str3 = "Hel";
        String str4 = "lo";
        String str5 = str3 + "lo";
        String str6 = str3 + str4;
        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str1 == str5 : " + (str1 == str5));
        System.out.println("str1 == str6 : " + (str1 == str6));
    }


}
