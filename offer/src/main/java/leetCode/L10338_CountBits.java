package leetCode;//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
//输出: [0,1,1,2,1,2]
//
// 进阶:
//
//
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
// 👍 779 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10338_CountBits {
    public static void main(String[] args) {
        System.out.println(JSONArray.toJSONString(countBits(15)));
    }

    public static int[] countBits(int n) {

        // f(x) = f(x/2)+f(x%2)
        if (n == 0) {
            return new int[]{};
        }


        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int index = 2; index <= n; index++) {
            result[index] = result[index / 2] + result[index % 2];
        }

        return result;
    }
}

