package leetCode;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 5885 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10003_LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }


    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] array = s.toCharArray();

        int maxCount = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;

        int indexCount = 0;

        Map<Character, List<Integer>> listMap = new HashMap<>();

        while (rightIndex < array.length && leftIndex <= rightIndex) {
            Character indexRightChar = array[rightIndex];

            List<Integer> temp = listMap.get(indexRightChar);

            //说明有重复的
            if (temp != null && removeLessLeftIndex(listMap.get(indexRightChar), leftIndex).size() >= 1) {

                Integer minValue = temp.get(0);
                temp.remove(minValue);
                indexCount = indexCount - (minValue - leftIndex + 1);
                leftIndex = minValue + 1;

                continue;
            }
            maxCount = Math.max(maxCount, ++indexCount);

            if (temp == null) {
                temp = new ArrayList<>();
                listMap.put(indexRightChar, temp);
            }
            temp.add(rightIndex++);
        }


        return maxCount;
    }

    private static List<Integer> removeLessLeftIndex(List<Integer> list, int leftIndex) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < leftIndex){
                list.remove(i);
            }

        }
        return list;

    }
}


