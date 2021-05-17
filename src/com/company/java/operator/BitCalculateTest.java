package com.company.java.operator;

public class BitCalculateTest {
    public static void testNot() {
        int a = 1;
        int b = ~a;
        System.out.println(b);
    }

    //掩码技术：使用位与操作符，得到整数中的各个位
    //保留二进制表示的整数n，从右边开始数的，第四位上的数字
    public static void testMask() {
        int n = 123;
        //0B表示二进制
        int m = n & 0B1000;
        System.out.println("数字n的二进制表示是" + Integer.toBinaryString(n));
        System.out.println("和0B1000位运算后等于" + Integer.toBinaryString(m));
    }

    public static void testConcat(){
        //二进制数字变量
        //每两位可以保存一个特定的标志
        int value=0B00000000;
        System.out.println("初始值："+Integer.toBinaryString(value));
        //A标志
        int flagA=0B11000000;
        //B标志
        int flagB=0B00110000;
        //C标志
        int flagC=0B00001100;
        //D标志
        int flagD=0B00000011;
        //拼接A标志，结果=0B11000000
        value=value|flagA;
        System.out.println("拼接A标志："+Integer.toBinaryString(value));


        value=value|flagA;
        System.out.println("重复拼接A标志："+Integer.toBinaryString(value));

        //A标志取反，结果=0B00111111
        //删除A标志，结果=0B00000000
        value=value&~flagA;
        System.out.println("删除A标志："+Integer.toBinaryString(value));

        //拼接ABCD标志，结果=0B11111111
        value=value|flagA;
        value=value|flagB;
        value=value|flagC;
        value=value|flagD;
        System.out.println("拼接ABCD标志："+Integer.toBinaryString(value));

        //B标志取反，结果=0B11001111
        //删除B标志，结果=0B11001111
        value=value&~flagB;
        System.out.println("删除B标志："+Integer.toBinaryString(value));

        value=value&~flagB;
        System.out.println("重复删除B标志："+Integer.toBinaryString(value));

        System.out.println("判断是否拼接了C标志：");
        if((value&flagC)!=0){
            System.out.println("已经拼接了C标志");
        }else {
            System.out.println("没有拼接C标志");
        }

        System.out.println("判断是否拼接了B标志：");
        if((value&flagB)!=0){
            System.out.println("已经拼接了B标志");
        }else {
            System.out.println("没有拼接B标志");
        }
    }
}
