package com.java.study.zuo.vedio.advanced.chapter6;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 * 子矩阵的最大累加和问题
 * 【题目】 给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。 例如，矩阵matrix为:
 * -90    48  78
 * 64	 -40  64
 * -81	  -7  66
 * <p>
 * 其中，最大累加和的子矩阵为:
 * 48 78
 * -40 64
 * -7 66
 * 所以返回累加和209
 * <p>
 * 例如，matrix为:
 * -1-1 -1
 * -1 2  2
 * -1 -1 -1
 * 其中，最大累加和的子矩阵为:
 * 2  2
 * 所以返回累加和4
 *
 * @author hushiye
 * @since 2020-09-17 17:20
 */
public class SubMatrixMaxSum {

    public static int subMatrixMaxSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] tempArray = new int[matrix[0].length];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int row = i; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    tempArray[col] += matrix[row][col];
                }
                int sumValue = 0;
                for (int j = 0; j < tempArray.length; j++) {
                    sumValue += tempArray[j];
                    maxValue = Math.max(maxValue, sumValue);
                    sumValue = sumValue > 0 ? sumValue : 0;
                }

            }

            tempArray = new int[tempArray.length];

        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[][] arr = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(subMatrixMaxSum(arr));
        int[][] arr2 = {{-1,-1, -1}, {-1,2 ,2}, {-1, -1 ,-1}};
        System.out.println(subMatrixMaxSum(arr2));
    }

}
