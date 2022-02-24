package leetCode;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯
// 👍 1270 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10078_Subsets {

    public static void main(String[] args) {
        System.out.println(JSONArray.toJSONString(subsets(new int[]{1})));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> targetList = new ArrayList<>();
        List<Integer> resultCollect = new ArrayList<>();
        subsets(nums, targetList, resultCollect, 0);
        return targetList;
    }

    private static void subsets(int[] nums, List<List<Integer>> targetList, List<Integer> resultCollect, int index) {
        if (index == nums.length) {
            targetList.add(new ArrayList<>(resultCollect));
            return;
        }

        subsets(nums, targetList, resultCollect, index + 1);

        resultCollect.add(nums[index]);
        subsets(nums, targetList, resultCollect, index + 1);
        resultCollect.remove(resultCollect.size() - 1);
    }
}


