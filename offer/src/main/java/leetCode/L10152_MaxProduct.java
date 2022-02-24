package leetCode;//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
// 👍 1224 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10152_MaxProduct {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));

        System.out.println(maxProduct(new int[]{2, 3, -2, 4, -5}));

    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minValue = nums[0];
        int maxValue = nums[0];
        int result = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int maxEnd = maxValue * nums[index];
            int minEnd = minValue * nums[index];

            maxValue = Math.max(Math.max(maxEnd, minEnd), nums[index]);
            minValue = Math.min(Math.min(maxEnd, minEnd), nums[index]);
            result = Math.max(maxValue, result);
        }
        return result;

    }

//    private static int[] maxProduct(int[] nums, int index, int totalLength, int result) {
//
//
//
//        if (index > totalLength) {
//            return new int[]{1, 1};
//        }
//
//        int currentIndexValue = nums[index];
//        int notExcludedIndexValue = result;
//
//        int excludedIndexValue = currentIndexValue * result;
//
//        int[] halfResult = maxProduct(nums, index + 1, totalLength, 1);
//
//        int halfResultMaxValue =
//    }
//
//    private static int maxProduct(int[] nums, int curIndex, int stopIndex, List<Integer> list, Integer result) {
//        if (curIndex == stopIndex) {
//            return result;
//        }
//        int notExistCurValue = result;
//        list.add(curIndex);
//        int existCurValue = maxProduct(nums, curIndex + 1, stopIndex, list, result * nums[curIndex]);
//        list.remove(list.size() - 1);
//        return Math.max(notExistCurValue, existCurValue);
//    }
}


