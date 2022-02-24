package leetCode;//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
//输入：board =
// [['A','B','C','E'],
// ['S','F','C','S'],
// ['A','D','E','E']], word = 'AB
//CCED'
//输出：true
//
//
// 示例 2：
//
//
//输入：board =
// [['A','B','C','E'],
// ['S','F','C','S'],
// ['A','D','E','E']], word = 'SE
//E
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'AB
//CB'
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
// Related Topics 数组 回溯 矩阵
// 👍 980 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10079_Exist {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ESEC";
        System.out.printf(String.valueOf(exist(board, word)));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        if (word == "") {
            return true;
        }

        boolean[][] searchDp = new boolean[board.length][board[0].length];

        char[] wordCharArray = word.toCharArray();


        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean existFlag = exist(board, wordCharArray, searchDp, row, column, 0);
                if (existFlag) {
                    return existFlag;
                }
            }
        }
        return false;

    }

    private static boolean exist(char[][] board, char[] wordCharArray, boolean[][] searchDp, int row, int column, int checkWordIndex) {

        if (checkWordIndex == wordCharArray.length) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }

        if (searchDp[row][column] == true || board[row][column] != wordCharArray[checkWordIndex]) {
            return false;
        }

        //说明 矩阵 当前值与要比较的字符串值相等

        searchDp[row][column] = true;

        boolean otherCheck = exist(board, wordCharArray, searchDp, row, column - 1, checkWordIndex + 1);
        if (otherCheck) {
            return true;
        }

        otherCheck = exist(board, wordCharArray, searchDp, row, column + 1, checkWordIndex + 1);
        if (otherCheck) {
            return true;
        }


        otherCheck = exist(board, wordCharArray, searchDp, row + 1, column, checkWordIndex + 1);
        if (otherCheck) {
            return true;
        }


        otherCheck = exist(board, wordCharArray, searchDp, row - 1, column, checkWordIndex + 1);
        if (otherCheck) {
            return true;
        }
        searchDp[row][column] = false;
        return false;
    }
}



