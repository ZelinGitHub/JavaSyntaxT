package com.company.java.operator;

public class BitMaskTest {




    //掩码技术：使用位与操作符，得到整数中的各个位
    //保留二进制表示的整数n，从右边开始数的，第四位上的数字
    public static void testMask() {
        int n = 123;
        //0B表示二进制
        int m = n & 0B1000;
        System.out.println("数字n的二进制表示是" + Integer.toBinaryString(n));
        System.out.println("和0B1000位运算后等于" + Integer.toBinaryString(m));
    }

}
