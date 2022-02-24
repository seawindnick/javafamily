package leetCode;//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 数组 排序
// 👍 1052 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10056_Merge {

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 3}, {4, 5}};
        System.out.println(JSONArray.toJSONString(merge(arrays)));
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        for (int[] value : intervals) {

            int L = value[0];
            int R = value[1];

            if (result.isEmpty() || result.get(result.size() - 1)[1] < value[0]) {
                result.add(new int[]{L, R});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], value[1]);
            }

        }
        int[][] target = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            target[i] = result.get(i);

        }
        return target;

    }

//    public static int[][] merge(int[][] intervals) {
//
//        List<int[]> list = new ArrayList<>();
//
//        for (int i = 0; i < intervals.length; i++) {
//            int[] indexValue = intervals[i];
//            merge(list, indexValue);
//
//        }
//
//        int[][] target = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            target[i] = list.get(i);
//
//        }
//        return target;
//    }
//
//    private static void merge(List<int[]> list, int[] indexValue) {
//
//        for (int size = list.size() - 1; size >= 0; size--) {
//            int[] currentIndexValue = list.get(size);
//            int[] A = currentIndexValue;
//            int[] B = indexValue;
//            boolean flag = !(A[1] < B[0] || B[1] < A[0]);
//            if (flag) {
//                indexValue[0] = Math.min(A[0], B[0]);
//                indexValue[1] = Math.max(A[1], B[1]);
//                list.remove(size);
//            }
//        }
//        list.add(indexValue);
//    }
}

