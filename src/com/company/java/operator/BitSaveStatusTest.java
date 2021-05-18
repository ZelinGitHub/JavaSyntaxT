package com.company.java.operator;

import com.company.java.classobject.Size;

public class BitSaveStatusTest {
    //二进制数字变量
    //使用中间四位存储苹果的颜色
    //使用末尾两位存储苹果的尺寸
    private static int value = 0B00_0000_00;

    //红色
    private static final int RED = 0B00_0001_00;
    //绿色
    private static final int GREEN = 0B00_0010_00;
    //黄色
    private static final int YELLOW = 0B00_0100_00;
    //紫色
    private static final int PURPLE = 0B00_1000_00;


    //大苹果
    private static final int BIG = 0B00_0000_01;
    //小苹果
    private static final int SMALL = 0B00_0000_10;


    //掩码，用来判断是否已经有值
    private static final int COLOR_MASK = 0B00_1111_00;
    private static final int SIZE_MASK = 0B00_0000_11;


    public static void setValue() {
        System.out.println("初始值：" + Integer.toBinaryString(value));
        //因为1|0=1,0|1=1,0|0=0，所以对状态值和二进制数字变量位或，可以保存这个值
        value = value | RED;
        System.out.println("设置红色：" + Integer.toBinaryString(value));
        //因为1|1=1,0|0=0，所以重复保存一个状态值是没有效果的
        value = value | RED;
        System.out.println("重复设置红色：" + Integer.toBinaryString(value));
        //因为0|1=1,0|0=0，所以设置一个状态时不会影响其他状态
        value = value | BIG;
        System.out.println("设置尺寸：" + Integer.toBinaryString(value));
    }

    public static void clearValue() {
        System.out.println("初始值：" + Integer.toBinaryString(value));

        //因为1&0=0,0&1=0
        //（1）对状态值取反
        //（2）使用取反结果和二进制数字变量位与
        //计算结果必然是0，实现了清除
        //因为状态值的其他位都为0，取反后为1，并且1&1=1 1&0=0 0&1=0，所以不会影响其他状态位
                value = value & ~RED;
        System.out.println("清除颜色：" + Integer.toBinaryString(value));

        //因为0&1=0 0&0=0，重复清除一个状态值是没有效果的
        value = value & ~RED;
        System.out.println("重复清除颜色：" + Integer.toBinaryString(value));
    }


    public static void isSetTheValue() {
        //使用状态值和二进制数字变量位与之后
        //因为状态值的其他位都为0，所以其他的位都会被清0
        //因为不同的状态值1所在的位不同，所以如果已经存储了其他的状态值，位与结果
        // 这是一个掩码操作，将得到二进制数字变量中对应的位的当前值，

        //然后判断这个二进制数字变量是否为0，可以知道这个当前值是否为0，如果当前值不为0，表示已经拼接了目标值，否则没有拼接
        System.out.println("判断是否存储了绿色：");
        if ((value & GREEN) != 0) {
            System.out.println("已经拼接了C标志");
        } else {
            System.out.println("没有拼接C标志");
        }

        System.out.println("判断是否存储了红色：");
        if ((value & RED) != 0) {
            System.out.println("已经拼接了B标志");
        } else {
            System.out.println("没有拼接B标志");
        }
    }

    public static void isExistValue() {
        System.out.println("判断A位置是否存在值：");
        if ((value & COLOR_MASK) != 0) {
            System.out.println("已经拼接了C标志");
        } else {
            System.out.println("没有拼接C标志");
        }

        System.out.println("判断是否拼接了B标志：");
        if ((value & SIZE_MASK) != 0) {
            System.out.println("已经拼接了B标志");
        } else {
            System.out.println("没有拼接B标志");
        }
    }
}
