package com.company.java.array;

import java.util.ArrayList;
import java.util.List;

public class CWPrintMatrix {


    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //二维数组的元素，也就是一维数组的元素个数，是矩阵的列数
        int columnNumber = matrix[0].length;
        //二维数组的元素个数，也就是其中包含的一维数组个数，是矩阵的行数
        int rowNumber = matrix.length;

        int left = 0;
        int right = rowNumber - 1;
        int top = 0;
        int bottom = columnNumber - 1;
        while (left <= right && top <= bottom) {
            //第一步从左到右
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);//列在变化，行是最上面一行
            }
            //第二步从上到下 bottom>top
            if (bottom > top) {
                for (int i = top + 1; i <= bottom; ++i) {
                    list.add(matrix[i][right]);//行在变化，列是最右列
                }
            }
            //第三步从右到左 right>left&&bottom>top
            if (right > left && bottom > top) {
                for (int i = right - 1; i >= left; --i) {
                    list.add(matrix[bottom][i]); //列在变化，最低行
                }
            }
            //第四步从下到上
            if (bottom - 1 > top && right > left) {
                for (int i = bottom - 1; i > top; --i) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

}
