package com.company.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {


    //二维数组实际上是数组的数组
    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (columns == 0)
            return list;
        int left = 0;
        int right = rows - 1;
        int top = 0;
        int buttom = columns - 1;
        while (left <= right && top <= buttom) {
            //第一步从左到右
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);//列在变化，行是最上面一行
            }
            //第二步从上到下 buttom>top
            if (buttom > top) {
                for (int i = top + 1; i <= buttom; ++i) {
                    list.add(matrix[i][right]);//行在变化，列是最右列
                }
            }
            //第三步从右到左 right>left&&buttom>top
            if (right > left && buttom > top) {
                for (int i = right - 1; i >= left; --i) {
                    list.add(matrix[buttom][i]); //列在变化，最低行
                }
            }
            //第四步从下到上
            if (buttom - 1 > top && right > left) {
                for (int i = buttom - 1; i > top; --i) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return list;
    }

}
