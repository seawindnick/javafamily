package leetCode;//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针
// 👍 1261 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10031_NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 10, 8, 7};
        nextPermutation(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        //找出第一个升序的点 A1
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i >= 1) {
            // 找出末尾第一个比 A1 大的点。 A1。。。。X1,X2,X3,X4,X5 中 X1,X2,X3,X4,X5 不会存在升序的队列，只有降序的队列，如果有升序的队列，会在上一步就找出
            int j = n - 1;
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
            }
            swap(i - 1, j, nums);

            // 由于 i 后面都是降序排列，变为升序排列
            reverse(nums, i);
        } else {
            reverse(nums, 0);
        }
    }

    private static void reverse(int[] nums, int index) {
        int i = index;
        int j = nums.length - 1;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

