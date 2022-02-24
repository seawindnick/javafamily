package leetCode;//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 贪心 数组 双指针
// 👍 2679 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10011_MaxArea {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxValue = Integer.MIN_VALUE;

        while (leftIndex < rightIndex) {
            int value = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            maxValue = Math.max(maxValue, value);

            if (height[leftIndex] >= height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return maxValue;
    }

//    private static int maxArea(int[] height) {
//        List<Integer> leftArray = new ArrayList<>();
//        for (int i = 0; i < height.length; i++) {
//            if (leftArray.isEmpty() || height[i] > height[leftArray.get(leftArray.size() - 1)]) {
//                leftArray.add(i);
//            }
//        }
//
//        List<Integer> rightArray = new ArrayList<>();
//        for (int i = height.length - 1; i >= 0; i--) {
//            if (rightArray.isEmpty() || height[i] > height[rightArray.get(rightArray.size() - 1)]) {
//                rightArray.add(i);
//            }
//        }
//
//
//        int maxValue = Integer.MIN_VALUE;
//
//        for (Integer leftIndex : leftArray) {
//            for (Integer rightIndex : rightArray) {
//                if (leftIndex > rightIndex) {
//                    continue;
//                }
//                int value = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
//
//                maxValue = Math.max(maxValue, value);
//            }
//
//        }
//
//        return maxValue;
//    }

//    public static int maxArea(int[] height) {
//
//
//
//
////        if (height == null || height.length == 0) {
////            return 0;
////        }
////
////        int leftIndex = 0;
////        int rightIndex = height.length - 1;
////
////        int maxValue = Integer.MIN_VALUE;
////
////        while (leftIndex < rightIndex) {
////            int endIndex = rightIndex;
////            while (leftIndex < endIndex) {
////                int value = Math.min(height[leftIndex], height[endIndex]) * (endIndex - leftIndex);
////                maxValue = Math.max(maxValue, value);
////                endIndex--;
////            }
////            leftIndex++;
////        }
////        return maxValue;
//
//    }
}


