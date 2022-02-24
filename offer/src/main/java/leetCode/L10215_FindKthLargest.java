package leetCode;//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 👍 1213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10215_FindKthLargest {


    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 0};
        System.out.println(findKthLargest(arr, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] heapSortArray = new int[k];
        int insertIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (insertIndex < heapSortArray.length) {
                heapSortArray[insertIndex] = nums[index];
                heapInsert(heapSortArray, insertIndex);
                insertIndex++;
            } else {
                if (nums[index] > heapSortArray[0]) {
                    heapSortArray[0] = nums[index];
                    heapUpdate(heapSortArray, 0);
                }
            }
        }
        return heapSortArray[0];
    }

    private static void heapUpdate(int[] heapSortArray, int parentIndex) {
        int leftIndex;
        while ((leftIndex = 2 * parentIndex + 1) <= heapSortArray.length - 1) {
            int rightIndex = leftIndex + 1;
            int minValueIndex = rightIndex >= heapSortArray.length || heapSortArray[leftIndex] < heapSortArray[rightIndex] ? leftIndex : rightIndex;
            if (heapSortArray[parentIndex] < heapSortArray[minValueIndex]) {
                return;
            }

            swap(heapSortArray, minValueIndex, parentIndex);
            parentIndex = minValueIndex;
        }
    }

    //新增
    private static void heapInsert(int[] heapSortArray, int index) {
        int originalIndex = index;
        while (index != 0) {
            int parentIndex = (index - 1) / 2;
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;

            int minValueIndex = rightIndex > originalIndex || heapSortArray[leftIndex] < heapSortArray[rightIndex] ? leftIndex : rightIndex;
            if (heapSortArray[minValueIndex] > heapSortArray[parentIndex]) {
                return;
            }
            swap(heapSortArray, minValueIndex, parentIndex);
            index = parentIndex;
        }


    }

    private static void swap(int[] nums, int minValueIndex, int parentIndex) {
        int value = nums[minValueIndex];
        nums[minValueIndex] = nums[parentIndex];
        nums[parentIndex] = value;
    }

}


