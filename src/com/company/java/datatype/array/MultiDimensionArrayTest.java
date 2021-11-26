package com.company.java.datatype.array;

public class MultiDimensionArrayTest {
    //创建一个二维数组
    public static int[][] createTwoDimensionArray() {
        //先创建三个一维数组
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        int[] array3 = {9, 10, 11, 12};
        int[] array4 = {13, 14, 15, 16};
        //这是一个二维数组
        //可以当做是元素是一维数组的一维数组
        // 有三个元素，每个元素都是一维数组
        return new int[][]{
                array1
                , array2
                , array3
                , array4
        };
    }

    private static void printTwoDimensionArray1(int[][] twoDimensionArray) {
        //遍历二维数组
        for (int[] array : twoDimensionArray) {
            //遍历一维数组
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void printTwoDimensionArray2(int[][] twoDimensionArray) {
        //行数，也就是二维数组的元素个数
        int rowNumber = twoDimensionArray.length;
        //列数，也就是一维数组的元素个数
        int columnNumber = twoDimensionArray[0].length;
        //遍历二维数组
        //先遍历所有行，而后对每一行进行遍历
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                System.out.print(twoDimensionArray[i][j] + " ");
                if (j == columnNumber - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static void test() {
        int[][] twoDimensionArray = createTwoDimensionArray();
        printTwoDimensionArray1(twoDimensionArray);
        printTwoDimensionArray2(twoDimensionArray);
    }
}
