package leetCode;//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
//
//输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列）
// 👍 822 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10347_TopKFrequent {


    public static void main(String[] args) {
        System.out.println((-1) / 2);
        System.out.println(JSONArray.toJSONString(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> valueAndCountMap = buildValueAndCountMap(nums);

        int[] heapArray = new int[k];
        fillHeapArray(heapArray, valueAndCountMap);
        return heapArray;
    }


    private static void fillHeapArray(int[] heapArray, Map<Integer, Integer> valueAndCountMap) {

        int startIndex = 0;
        for (Map.Entry<Integer, Integer> valueAndCountEntry : valueAndCountMap.entrySet()) {
            int indexValue = valueAndCountEntry.getKey();
            int count = valueAndCountEntry.getValue();

            if (startIndex < heapArray.length) {
                heapArray[startIndex] = indexValue;
                heapAdd(heapArray, valueAndCountMap, startIndex);
                startIndex++;
            } else {
                if (count > valueAndCountMap.get(heapArray[0])) {
                    heapArray[0] = indexValue;
                    heapUpdate(heapArray, 0, heapArray.length - 1, valueAndCountMap);
                }
            }
        }


    }

    private static void heapUpdate(int[] heapArray, int parentIndex, int endIndex, Map<Integer, Integer> valueAndCountMap) {
        int leftIndex;
        while ((leftIndex = 2 * parentIndex + 1) <= endIndex) {
            int rightIndex = leftIndex + 1;
            //获取次数小的数据
            int minIndex = rightIndex > endIndex || valueAndCountMap.get(heapArray[leftIndex])
                    < valueAndCountMap.get(heapArray[rightIndex]) ? leftIndex : rightIndex;
            if (valueAndCountMap.get(heapArray[parentIndex]) > valueAndCountMap.get(heapArray[minIndex])) {
                swap(heapArray, minIndex, parentIndex);
                parentIndex = minIndex;
            } else {
                break;
            }

        }


    }

    private static void heapAdd(int[] heapArray, Map<Integer, Integer> valueAndCountMap, int endIndex) {
        int subIndex = endIndex;
        int parentIndex;
        while (subIndex > 0) {
            parentIndex = (subIndex - 1) / 2;

            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = leftIndex + 1;

            //获取次数小的数据
            int minIndex = rightIndex > endIndex || valueAndCountMap.get(heapArray[leftIndex])
                    < valueAndCountMap.get(heapArray[rightIndex]) ? leftIndex : rightIndex;
            if (valueAndCountMap.get(heapArray[minIndex]) < valueAndCountMap.get(heapArray[parentIndex])) {
                swap(heapArray, minIndex, parentIndex);
                subIndex = parentIndex;

            } else {
                break;
            }
        }

    }

    private static void swap(int[] heapArray, int minIndex, int parentIndex) {
        int temp = heapArray[minIndex];
        heapArray[minIndex] = heapArray[parentIndex];
        heapArray[parentIndex] = temp;
    }

    private static Map<Integer, Integer> buildValueAndCountMap(int[] nums) {

        HashMap<Integer, Integer> valueAndCountMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            Integer value = valueAndCountMap.getOrDefault(nums[index], 0);
            value = value + 1;
            valueAndCountMap.put(nums[index], value);
        }
        return valueAndCountMap;
    }
}

