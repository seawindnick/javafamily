package leetCode;//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
// 示例 3：
//
//
//输入：matrix = [[1]]
//输出：[[1]]
//
//
// 示例 4：
//
//
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
//
//
//
//
// 提示：
//
//
// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
// Related Topics 数组 数学 矩阵
// 👍 961 👎 0

import com.alibaba.fastjson.JSONArray;

/**
 * (0,2) --> (1,0)
 * (0,3) --> (3,0)
 * (0,1) --> (2,0)
 * (0,0) --> (3,0)
 * <p>
 * <p>
 * (1,0) --> (3,1)
 * (2,0) --> (3,2)
 * <p>
 * <p>
 * <p>
 * <p>
 * (3,0) --> (3,3)
 * (3,1) --> (2,3)
 * (3,2) --> (1,3)
 * <p>
 * [[5,1,9,11],
 * [2,4,8,10],
 * [13,3,6,7],
 * [15,14,12,16]
 * ]
 * <p>
 * <p>
 * [[15,13,2,5],
 * [14,3,4,1],
 * [12,6,8,9],
 * [16,7,10,11]]
 */

//leetcode submit region begin(Prohibit modification and deletion)
public class L10048_Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(JSONArray.toJSONString(matrix));
    }


    public static void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int leftUpRow = 0;
        int leftUpCol = 0;

        int rightDownRow = matrix.length - 1;
        int rightDownCol = matrix[0].length - 1;

        int length = matrix[0].length - 1;

        rotate(matrix, leftUpRow, leftUpCol, rightDownRow, rightDownCol, length);

    }

    private static void rotate(int[][] matrix, int leftUpRow, int leftUpCol, int rightDownRow, int rightDownCol, int length) {
        if (leftUpCol > rightDownCol || leftUpRow > rightDownRow) {
            return;
        }


        for (int column = leftUpCol; column < rightDownCol; column++) {
            int upValue = matrix[leftUpRow][column];

            matrix[leftUpRow][column] = matrix[length - column][leftUpCol];

            matrix[length - column][leftUpCol] = matrix[rightDownRow][length - column];

            matrix[rightDownRow][length - column] = matrix[column][rightDownCol];


            matrix[column][rightDownCol] = upValue;
        }

        rotate(matrix, leftUpRow + 1, leftUpCol + 1, rightDownRow - 1, rightDownCol - 1, length);


    }


}

