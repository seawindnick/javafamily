package com.java.study.zuo.vedio.advanced.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 16:40
 */
public class LongestIncreasingPathInAMatrix {


    public static int longestIncreasingPathInAMatrix3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int maxLevel = 0;
        Integer[][] dp = new Integer[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int indexValue = matrix[i][j];
                int tempLevel = longestIncreasingPathInAMatrix3(matrix, i - 1, j, rowLength, colLength, indexValue,dp) + 1;
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix3(matrix, i + 1, j, rowLength, colLength, indexValue,dp) + 1);
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix3(matrix, i, j - 1, rowLength, colLength, indexValue,dp) + 1);
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix3(matrix, i, j + 1, rowLength, colLength, indexValue,dp) + 1);
                maxLevel = Math.max(maxLevel, tempLevel);

            }

        }
        return maxLevel;
    }

    private static int longestIncreasingPathInAMatrix3(int[][] matrix, int rowIndex, int colIndex, int rowLength, int colLength, int indexValue,Integer[][] dp) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= rowLength || colIndex >= colLength || matrix[rowIndex][colIndex] >= indexValue) {
            return 0;
        }
        if (dp[rowIndex][colIndex] != null){
            return dp[rowIndex][colIndex];
        }

        dp[rowIndex][colIndex] = longestIncreasingPathInAMatrix3(matrix, rowIndex - 1, colIndex, rowLength, colLength, matrix[rowIndex][colIndex],dp) + 1;
        dp[rowIndex][colIndex] = Math.max(dp[rowIndex][colIndex], longestIncreasingPathInAMatrix3(matrix, rowIndex + 1, colIndex, rowLength, colLength, matrix[rowIndex][colIndex],dp) + 1);
        dp[rowIndex][colIndex] = Math.max(dp[rowIndex][colIndex], longestIncreasingPathInAMatrix3(matrix, rowIndex, colIndex - 1, rowLength, colLength, matrix[rowIndex][colIndex],dp) + 1);
        dp[rowIndex][colIndex] = Math.max(dp[rowIndex][colIndex], longestIncreasingPathInAMatrix3(matrix, rowIndex, colIndex + 1, rowLength, colLength, matrix[rowIndex][colIndex],dp) + 1);

        return dp[rowIndex][colIndex];
    }


    public static int longestIncreasingPathInAMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int maxLevel = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int indexValue = matrix[i][j];
                int tempLevel = longestIncreasingPathInAMatrix2(matrix, i - 1, j, rowLength, colLength, indexValue) + 1;
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, i + 1, j, rowLength, colLength, indexValue) + 1);
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, i, j - 1, rowLength, colLength, indexValue) + 1);
                tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, i, j + 1, rowLength, colLength, indexValue) + 1);
                maxLevel = Math.max(maxLevel, tempLevel);

            }

        }
        return maxLevel;
    }

    private static int longestIncreasingPathInAMatrix2(int[][] matrix, int rowIndex, int colIndex, int rowLength, int colLength, int indexValue) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= rowLength || colIndex >= colLength || matrix[rowIndex][colIndex] >= indexValue) {
            return 0;
        }
        int tempLevel = longestIncreasingPathInAMatrix2(matrix, rowIndex - 1, colIndex, rowLength, colLength, matrix[rowIndex][colIndex]) + 1;
        tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, rowIndex + 1, colIndex, rowLength, colLength, matrix[rowIndex][colIndex]) + 1);
        tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, rowIndex, colIndex - 1, rowLength, colLength, matrix[rowIndex][colIndex]) + 1);
        tempLevel = Math.max(tempLevel, longestIncreasingPathInAMatrix2(matrix, rowIndex, colIndex + 1, rowLength, colLength, matrix[rowIndex][colIndex]) + 1);

        return tempLevel;
    }


    public static int longestIncreasingPathInAMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxLevel = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int level = getLongestIncreasingPathInAMatrix(matrix, i, j, matrix.length - 1, matrix[0].length - 1);
                maxLevel = Math.max(maxLevel, level);
            }

        }
        return maxLevel;
    }

    private static int getLongestIncreasingPathInAMatrix(int[][] matrix, int starRowIndex, int colStartIndex, int rowEndIndex, int colEndIndex) {
        if (starRowIndex > rowEndIndex || colStartIndex > colEndIndex) {
            return 0;
        }

        int level = 0;
        //上
        if (starRowIndex >= 1 && matrix[starRowIndex][colStartIndex] < matrix[starRowIndex - 1][colStartIndex]) {
            int levelTemp = getLongestIncreasingPathInAMatrix(matrix, starRowIndex - 1, colStartIndex, rowEndIndex, colEndIndex);
            level = Math.max(level, levelTemp);
        }
        //下
        if (starRowIndex < rowEndIndex && matrix[starRowIndex][colStartIndex] < matrix[starRowIndex + 1][colStartIndex]) {
            int levelTemp = getLongestIncreasingPathInAMatrix(matrix, starRowIndex + 1, colStartIndex, rowEndIndex, colEndIndex);
            level = Math.max(level, levelTemp);
        }

        //左
        if (colStartIndex >= 1 && matrix[starRowIndex][colStartIndex] < matrix[starRowIndex][colStartIndex - 1]) {
            int levelTemp = getLongestIncreasingPathInAMatrix(matrix, starRowIndex, colStartIndex - 1, rowEndIndex, colEndIndex);
            level = Math.max(level, levelTemp);
        }


        //右
        if (colStartIndex < colEndIndex && matrix[starRowIndex][colStartIndex] < matrix[starRowIndex][colStartIndex + 1]) {
            int levelTemp = getLongestIncreasingPathInAMatrix(matrix, starRowIndex, colStartIndex + 1, rowEndIndex, colEndIndex);
            level = Math.max(level, levelTemp);
        }

        return level + 1;
    }


    public static void main(String[] args) {
        int[][] arr = {{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        System.out.println(longestIncreasingPathInAMatrix3(arr));
    }

}
