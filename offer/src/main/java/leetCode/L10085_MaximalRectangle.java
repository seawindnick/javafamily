package leetCode;//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix =
// [['1','0','1','0','0'],
// ['1','0','1','1','1'],
// ['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：6
//解释：最大矩形如上图所示。
//
//
// 示例 2：
//
//
//输入：matrix = []
//输出：0
//
//
// 示例 3：
//
//
//输入：matrix = [['0']]
//输出：0
//
//
// 示例 4：
//
//
//输入：matrix = [['1']]
//输出：1
//
//
// 示例 5：
//
//
//输入：matrix = [['0','0']]
//输出：0
//
//
//
//
// 提示：
//
//
// rows == matrix.length
// cols == matrix[0].length
// 0 <= row, cols <= 200
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈
// 👍 984 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10085_MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        
//        [
//        ['1','0','1','0','0'],
//        ['1','0','1','1','1'],
//        ['1','1','1','1','1'],
//        ['1','0','0','1','0']
//        ]
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] countOneArray = new int[matrix[0].length];
        int maxValue = Integer.MIN_VALUE;


        /**
         * 【'1','0','1','0','0'},
         * {'1','0','1','1','1'},
         * {'1','1','1','1','1'},
         * {'1','0','0','1','0'】
         */


        for (int startRow = 0; startRow < matrix.length; startRow++) {
            calculateCountOneArray(countOneArray, matrix[startRow]);
            int calculateValue = calculateRectangleArea(countOneArray);
            maxValue = Math.max(calculateValue, maxValue);

            for (int secondRow = startRow + 1; secondRow < matrix.length; secondRow++) {
                char[] secondRowArray = matrix[secondRow];
                calculateCountOneArray(countOneArray, secondRowArray);
                maxValue = Math.max(calculateRectangleArea(countOneArray), maxValue);
            }
            cleanCountOneArray(countOneArray);
        }
        return maxValue;
    }


    private static int calculateRectangleArea(int[] countOneArray) {
        int maxHeight = Integer.MIN_VALUE;
        for (int indexCount : countOneArray) {
            maxHeight = Math.max(indexCount, maxHeight);
        }

        int length = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int indexCount : countOneArray) {
            if (indexCount == maxHeight) {
                length++;
                maxLength = Math.max(length,maxLength);
            } else {
                length = 0;
            }

        }
        return maxHeight * maxLength;
    }

    private static void cleanCountOneArray(int[] countOneArray) {
        for (int row = 0; row < countOneArray.length; row++) {
            countOneArray[row] = 0;
        }
    }

    private static void calculateCountOneArray(int[] countOneArray, char[] calculateRow) {
        for (int i = 0; i < countOneArray.length; i++) {
            countOneArray[i] = calculateRow[i] == '1' ? countOneArray[i] + 1 : 0;
        }

        System.out.println(JSONArray.toJSON(countOneArray));
        System.out.println("-------------------");
    }
}


