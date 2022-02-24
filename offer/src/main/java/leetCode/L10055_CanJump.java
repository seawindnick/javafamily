package leetCode;//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心算法 数组
// 👍 1169 👎 0


import com.alibaba.fastjson.JSONObject;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10055_CanJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }

    private static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }


        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxValue) {
                maxValue = Math.max(maxValue, i + nums[i]);
                if (maxValue >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static boolean canJump(int[] nums) {
//        if (nums == null) {
//            return false;
//        }
//
//
//        int startIndex = 0;
//        return canJump(nums, startIndex);
//    }
//
//    private static boolean canJump(int[] nums, int startIndex) {
//        if (startIndex >= nums.length - 1) {
//            return true;
//        }
//
//        int indexValue = nums[startIndex];
//
//        for (int i = 1; i <= indexValue; i++) {
//            boolean tempFlag = canJump(nums, startIndex + i);
//            if (tempFlag) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}


