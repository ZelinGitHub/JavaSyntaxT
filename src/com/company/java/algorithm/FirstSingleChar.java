package com.company.java.algorithm;

public class FirstSingleChar {

    public char getFirstSingleChar(String str) {

        //记录字符出现次数的数组
        //使用字符的整数值，作为数组元素的角标
        //使用字符出现的次数，作为数组元素的值
        //一共只有256个字符
        int[] repetitions = new int[256];

        for (int i = 0; i < str.length(); i++) {
            //得到指定位置的字符
            int position = (int) str.charAt(i);
            repetitions[position] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            int loc = (int) str.charAt(i);
            if (repetitions[loc] == 1)
                return (char) loc;
        }
        return '\0';
    }
}
