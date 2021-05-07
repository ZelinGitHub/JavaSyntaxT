package com.company.java.array;

public class CreateArrayTest {
    public int n = 10;

    public void decArrayVar() {
        int[] a;
        int b[];
    }

    public void createArray() {
        //创建数据时，需要指定数据的容量
        //一旦创建了数组，就不能再改变它的大小
        int[] num = new int[100];
        //数组的容量不要求是常量
        int[] num2 = new int[n];
        //Java中允许数组容量为0
        //长度为0的数组与null 不同
        int[] num3 = new int[0];
    }

    public void createArrayAndSaveData(){
        //同时创建数组并存储元素
        //数组的大小就是存储的值的个数
        int[] smallPrimes={2,3,5,7,11,13};
    }
}
