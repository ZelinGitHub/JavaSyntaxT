package com.company.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CWPrintMatrix {


    public static void cwPrintMatrix(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        //二维数组的元素是一维数组，它的元素个数，是矩阵的列数
        int columnNumber = matrix[0].length;
        //二维数组的元素个数，也就是其中包含的一维数组个数，是矩阵的行数
        int rowNumber = matrix.length;
        //每次从左到右遍历时的起始元素角标
        //每次从右到左遍历时的结束元素角标
        //初始为0，随着对矩阵的遍历会逐渐增大
        int left = 0;
        //每次从左到右遍历时的结束元素角标
        //每次从右到左遍历时的起始元素角标
        //初始为列数-1，随着对矩阵的遍历会逐渐减小
        int right = columnNumber - 1;
        //每次从上到下遍历时的起始元素角标
        //每次从下到上遍历时的结束元素角标
        //初始为0，随着对矩阵的遍历会逐渐增大
        int top = 0;
        //每次从上到下遍历时的结束元素角标
        //每次从下到上遍历时的起始元素角标
        //初始为行数-1，随着对矩阵的遍历会逐渐减小
        int bottom = rowNumber - 1;
        //每次循环都是左右--上下--右左--下上的一个轮回
        //第一步从左到右
        //只有left<=right，才可以从左向右遍历
        while (left <= right ) {
            for (int i = left; i <= right; ++i) {
                //二维数组的第一个角标，是行角标
                //列在变化，行不变保持最上值
                list.add(matrix[top][i]);
            }
            //第二步从上到下
            //只有从左到右遍历后，才能开始从上到下的遍历
            //只有top<bottom时，才可以从上向下遍历
            if (top < bottom) {
                //第一个值已经被从左到右遍历到了，所以i初始值是top+1
                for (int i = top + 1; i <= bottom; ++i) {
                    //行在变化，列不变保持最右值
                    list.add(matrix[i][right]);
                }
                //第三步从右到左
                //只有从上到下遍历后，才能开始从右到左的遍历
                //只有left<right，才可以从右到左遍历
                if (left < right) {
                    //第一个值已经被从上到下遍历到了，所以i初始值是right - 1
                    for (int i = right - 1; i >= left; --i) {
                        //列在变化，行不变保持最下值
                        list.add(matrix[bottom][i]);
                    }
                    //第四步从下到上
                    //只有从右到左遍历后，才能开始从下到上的遍历
                    //只有top<bottom-1，才可以从下到上遍历
                    if (top < bottom - 1) {
                        //第一个值已经被从右到左遍历到了，所以i初始值是bottom - 1
                        for (int i = bottom - 1; i > top; --i) {
                            //行在变化，列不变保持最左值
                            list.add(matrix[i][left]);
                        }
                    }
                }
            }
            //左向右的起始角标和右向左的结束角标加大、
            //左向右的结束角标和右向左的起始角标减小
            //上至下的起始角标和下至上的结束角标加大
            //上至下的结束角标和下至上的起始角标减小
            //符合顺时针遍历矩阵的逻辑
            left++;
            right--;
            top++;
            bottom--;
        }
        System.out.println(list.toString());
    }

    public static void test(){
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        int[] array3 = {9, 10, 11, 12};
        int[] array4 = {13, 14, 15, 16};
        int[][] matrix = {
                array1
                , array2
                , array3
                , array4
        };
        cwPrintMatrix(matrix);
    }

}
