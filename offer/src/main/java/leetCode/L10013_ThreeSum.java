package leetCode;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 3610 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10013_ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

        System.out.println(JSONArray.toJSONString(lists));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> target = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            int secondIndex = i + 1;
            int endIndex = nums.length - 1;

            while (secondIndex < endIndex) {
                int num = nums[i] + nums[secondIndex] + nums[endIndex];
                if (num == 0) {
                    ArrayList arrayList = new ArrayList();


                    arrayList.addAll(Arrays.asList(nums[i], nums[secondIndex], nums[endIndex]));
                    target.add(arrayList);

                    while (secondIndex < endIndex && nums[secondIndex] == nums[secondIndex + 1]) {
                        secondIndex++;
                    }

                    while (secondIndex < endIndex && nums[endIndex] == nums[endIndex - 1]) {
                        endIndex--;
                    }

                    secondIndex++;
                    endIndex--;


                } else if (num > 0) {
                    endIndex--;
                } else {
                    secondIndex++;
                }

            }
        }

        return target;

    }

//
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length <= 2) {
//            return new ArrayList<>();
//        }
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = map.get(nums[i]);
//            if (list == null) {
//                list = new ArrayList<>();
//                map.put(nums[i], list);
//            }
//            list.add(i);
//        }
//
//
//        int leftIndex = 0;
//
//        Set<String> set = new HashSet<>();
//
//        while (leftIndex < nums.length) {
//            int rightIndex = nums.length - 1;
//            while (leftIndex < rightIndex) {
//                int totalValue = nums[leftIndex] + nums[rightIndex];
//                if (map.containsKey(-totalValue)) {
//                    List<Integer> list = map.get(-totalValue);
//                    if (list != null) {
//                        int count = list.size();
//                        if (list.contains(leftIndex)){
//                            count--;
//                        }
//
//                        if (list.contains(rightIndex)){
//                            count--;
//                        }
//
//                        if (count > 0){
//                            List<Integer> targetList = new ArrayList<>();
//                            targetList.add(nums[leftIndex]);
//                            targetList.add(nums[rightIndex]);
//                            targetList.add(-totalValue);
//                            Collections.sort(targetList);
//
//                            String result = new String();
//                            for (Integer integer : targetList) {
//                                result = result + integer + "#";
//                            }
//
//                            set.add(result);
//                        }
//
//                    }
//                }
//
//                rightIndex--;
//
//            }
//
//            leftIndex++;
//        }
//
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (String str : set) {
//            String[] arr = str.split("#");
//
//            List list = new ArrayList();
//            for (String s : arr) {
//                list.add(Integer.parseInt(s));
//            }
//
//            result.add(list);
//        }
//
//        return result;
//
//    }
}

