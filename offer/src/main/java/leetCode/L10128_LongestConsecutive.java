package leetCode;//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
//
// Related Topics 并查集 数组 哈希表
// 👍 862 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10128_LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{-100, 4, -200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> elementValueSet = new HashSet<>();
        for (int num : nums) {
            elementValueSet.add(num);
        }

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!elementValueSet.contains(nums[i] - 1)) {
                int indexValue = nums[i];
                int length = 1;
                while (elementValueSet.contains(++indexValue)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;

//        int minValue = Integer.MAX_VALUE;
//        int maxValue = Integer.MIN_VALUE;
//        for (int num : nums) {
//            minValue = Math.min(minValue, num);
//            maxValue = Math.max(maxValue, num);
//        }
//
//        int length = maxValue - minValue;
//        byte[] existArray = new byte[length + 1];
//
//        boolean minMaxAllLegZero = minValue >= 0 && maxValue >= 0;
//
//        for (int indexValue : nums) {
//            int byteIndex = minMaxAllLegZero ? indexValue - minValue : indexValue + Math.abs(minValue);
//            existArray[byteIndex] = 1;
//        }
//
//        int count = 0;
//        int maxLength = Integer.MIN_VALUE;
//        for (int index = 0; index < existArray.length; index++) {
//            if (existArray[index] > 0) {
//                count++;
//                maxLength = Math.max(maxLength, count);
//            } else {
//                count = 0;
//            }
//        }
//
//        return maxLength;
    }
}

