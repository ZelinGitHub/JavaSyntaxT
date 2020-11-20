package com.company.java.datatype;

public class StringTest {
    public static void test() {
        String str1 = "Hello";
        String str2 = new String(str1);
        String str3 = str1;
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }

    public static void test2() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = str1;
        String str4 = new String(str1);
        String str5 = "Hel" + "llo";
        String str6 = "Hellooo".substring(0, 5);
        String str7 = "Hello".substring(0, 5);
        System.out.println("Hello" == "Hello");
        System.out.println(str2 == "Hello");
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);
        System.out.println(str1 == str6);
        System.out.println(str1 == str7);
    }

    public static void test3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fu");
        stringBuilder.append("ck");
        stringBuilder.append(" ");
        stringBuilder.append("u");
        stringBuilder.append("!");
        String completeStr=stringBuilder.toString();
    }
}
