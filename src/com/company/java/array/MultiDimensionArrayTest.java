package com.company.java.array;

public class MultiDimensionArrayTest {
    //创建一个二维数组
    public static void createTwoDimensionArray() {
        //先创建三个一维数组
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        int[] array3 = {9, 10, 11, 12};
        int[] array4 = {13, 14, 15, 16};

        //这是一个二维数组
        //可以当做是元素是一维数组的一维数组
        // 有三个元素，每个元素都是一维数组
        int[][] twoDimensionArray = {
                array1
                , array2
                , array3
                , array4
        };


        //遍历二维数组
        for (int i = 0; i < twoDimensionArray.length; i++) {
            int[] array = twoDimensionArray[i];
            //遍历一维数组
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }
}
