package com.company.java.algorithm;

public class GetFirstSingleChar {

    public static char getFirstSingleChar(String str) {

        //记录字符出现次数的数组
        //一共只有256个字符，每个字符都对应整数256以内的一个整数
        //使用字符的整数值，作为数组元素的角标
        //使用字符出现的次数，作为数组元素的值
        //这个数组就是一个散列表，数组元素的角标是key，数组元素的值是value
        int[] repetitions = new int[256];

        //遍历字符串的每一个字符
        for (int i = 0; i < str.length(); i++) {
            //得到指定位置的字符
            char c = str.charAt(i);
            //得到字符的整数值
            //用字符的整数值作为数组的角标
            //同一个字符的角标相同，将导致数组的元素值加1
            repetitions[c] += 1;
        }
        //遍历字符串的每一个字符
        //因为要得到字符串中第一个只出现一次的字符，所以要遍历字符串
        //而数组中的字符顺序是字符的整数值从小到大的顺序
        for (int i = 0; i < str.length(); i++) {
            //得到指定位置的字符
            char c = str.charAt(i);
            //如果数组元素值为1，说明这个字符只出现了一次
            if (repetitions[c] == 1)
                return c;
        }
        return ' ';
    }

    public static void test(){
        String str1="aaabbbcccdefg";
        String str2="aaabbbcccefg";
        String str3="aaabbbcccfg";
        String str4="aaabbbcccg";
        char c1=getFirstSingleChar(str1);
        char c2=getFirstSingleChar(str2);
        char c3=getFirstSingleChar(str3);
        char c4=getFirstSingleChar(str4);
        System.out.println("The first single char in str1 is "+c1);
        System.out.println("The first single char in str2 is "+c2);
        System.out.println("The first single char in str3 is "+c3);
        System.out.println("The first single char in str4 is "+c4);
    }
}
