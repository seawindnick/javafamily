package leetCode;//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
//
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
// 示例 4：
//
//
//输入: candidates = [1], target = 1
//输出: [[1]]
//
//
// 示例 5：
//
//
//输入: candidates = [1], target = 2
//输出: [[1,1]]
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯
// 👍 1467 👎 0


import com.alibaba.fastjson.JSONArray;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10039_CombinationSum {


    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum(candidates, 7);

        System.out.println(JSONArray.toJSONString(lists));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> targetList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        combinationSum(candidates, target, targetList, result, 0);

        return targetList;
    }

    private static void combinationSum(int[] candidates, int target, List<List<Integer>> targetList, List<Integer> result, int curIndex) {
        if (curIndex == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            targetList.add(new ArrayList<>(result));
            return;
        }

        //不包含当前值
        combinationSum(candidates, target, targetList, result, curIndex + 1);

        if (target >= candidates[curIndex]) {
            //包含当前值
            result.add(candidates[curIndex]);
            combinationSum(candidates, target - candidates[curIndex], targetList, result, curIndex);
            result.remove(result.size() - 1);
        }
    }


//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        Map<Integer, List<List<Integer>>> dp = new HashMap<>();
//
//
//        combinationSum(candidates, target, dp, 0);
//        return dp.get(target);
//
//    }

//    private static List<List<Integer>> combinationSum(int[] candidates, int target, Map<Integer, List<List<Integer>>> dp, int startIndex) {
//        if (target < 0 || startIndex >= candidates.length) {
//            return new ArrayList<>();
//        }
//
//        Set<List<Integer>> value = new HashSet<>();
//
//        for (int i = startIndex; i < candidates.length; i++) {
//            if (candidates[i] > target) {
//                break;
//            }
//
//            if (candidates[i] == target) {
//                List<Integer> list = new ArrayList<>();
//                list.add(candidates[i]);
//                value.add(list);
//            } else {
//                // 要这个值
//                List<List<Integer>> cloudThisValue = combinationSum(candidates, target - candidates[i], dp, startIndex);
//                for (List<Integer> list : cloudThisValue) {
//                    ArrayList<Integer> arrayList = new ArrayList<>(list);
//                    arrayList.add(candidates[i]);
//
//                    arrayList.sort(new Comparator<Integer>() {
//                        @Override
//                        public int compare(Integer o1, Integer o2) {
//                            return o1 - o2;
//                        }
//                    });
//                    value.add(arrayList);
//                }
//
//
//                //不要这个值
//                List<List<Integer>> notCloudThisValue = combinationSum(candidates, target, dp, startIndex + 1);
//                for (List<Integer> list : notCloudThisValue) {
//                    ArrayList arrayList = new ArrayList<>(list);
//                    arrayList.sort(new Comparator<Integer>() {
//                        @Override
//                        public int compare(Integer o1, Integer o2) {
//                            return o1 - o2;
//                        }
//                    });
//                    value.add(arrayList);
//                }
//
//            }
//        }
//
//        dp.put(target, new ArrayList<>(value));
//
//        return dp.get(target);
//    }
//             [[3,6,6],[3,3,3,3,3],[7,8],[3,5,7],[4,5,6],[5,5,5],[6,9],[3,4,8],[4,4,7],[3,3,9],[4,11],[3,12],[3,3,3,6],[3,3,4,5],[3,3,3,6]]
//    Expected:[[3,3,3,3,3],[3,3,3,6],[3,3,4,5],[3,3,9],[3,4,4,4],[3,4,8],[3,5,7],[3,6,6],[3,12],[4,4,7],[4,5,6],[4,11],[5,5,5],[6,9],[7,8]]
}


