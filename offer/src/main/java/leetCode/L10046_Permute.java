package leetCode;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
// 👍 1485 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10046_Permute {

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        List<List<Integer>> lists = permute(arr);
        System.out.println(JSONArray.toJSONString(lists));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> targetList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums, targetList, list, 0);
        return targetList;
    }

    private static void permute(int[] nums, List<List<Integer>> targetList, List<Integer> list, int currentIndex) {
        if (currentIndex == nums.length) {
            targetList.add(new ArrayList<>(list));
            return;
        }


        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, currentIndex, i);
            list.add(nums[currentIndex]);
            permute(nums, targetList, list, currentIndex + 1);
            list.remove(list.size() - 1);
            swap(nums, currentIndex, i);
        }


    }

    private static void swap(int[] nums, int currentIndex, int i) {
        int temp = nums[currentIndex];
        nums[currentIndex] = nums[i];
        nums[i] = temp;
    }
}


