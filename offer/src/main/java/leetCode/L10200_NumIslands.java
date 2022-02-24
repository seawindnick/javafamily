package leetCode;//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 1272 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10200_NumIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int rows = 0; rows < grid.length; rows++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[rows][column] == '1') {
                    count++;
                    infectIsland(grid, rows, column, grid.length, grid[0].length);
                    System.out.println(JSONArray.toJSON(grid));
                }
            }
        }
        return count;
    }

    private static void infectIsland(char[][] grid, int rows, int column, int rowLength, int columnLength) {
        if (rows >= rowLength || column >= columnLength || rows < 0 || column < 0 || grid[rows][column] == '2' || grid[rows][column] == '0') {
            return;
        }
        grid[rows][column] = '2';
        infectIsland(grid, rows - 1, column, rowLength, columnLength);
        infectIsland(grid, rows + 1, column, rowLength, columnLength);

        infectIsland(grid, rows, column + 1, rowLength, columnLength);
        infectIsland(grid, rows, column - 1, rowLength, columnLength);
    }

}


