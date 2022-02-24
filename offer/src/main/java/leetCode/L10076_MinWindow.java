package leetCode;//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
// 注意：
//
//
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
// 示例 3:
//
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口
// 👍 1280 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10076_MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

    private static String minWindow(String s, String t) {
        if (s == null && t != null || t == null) {
            return "";
        }

        int beginIndex = 0;
        int endIndex = 0;

        Map<Character, Integer> targetCharsetCountMap = new HashMap<>();
        for (char targetChar : t.toCharArray()) {
            Integer count = targetCharsetCountMap.getOrDefault(targetChar, 0);
            targetCharsetCountMap.put(targetChar, ++count);
        }

        Map<Character, Integer> sourceCharsetCountMap = new HashMap<>();
        int minBeginIndex = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int minEndLength = Integer.MAX_VALUE;


        while (beginIndex <= endIndex && endIndex < s.length()) {
            Character endCharset = s.charAt(endIndex);
            Integer count = sourceCharsetCountMap.getOrDefault(endCharset, 0);
            sourceCharsetCountMap.put(endCharset, ++count);
            endIndex++;

            while (checkSourceContainsTarget(sourceCharsetCountMap, targetCharsetCountMap)) {
                int length = endIndex - beginIndex;
                if (length < minLength) {
                    minLength = length;
                    minBeginIndex = beginIndex;
                    minEndLength = endIndex;
                }
                Character beginCharset = s.charAt(beginIndex);
                sourceCharsetCountMap.put(beginCharset, sourceCharsetCountMap.get(beginCharset) - 1);
                beginIndex++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minBeginIndex, minEndLength);
    }

//    public static String minWindow(String s, String t) {
//        if (s == null && t != null || t == null) {
//            return "";
//        }
//
//        int beginIndex = 0;
//        int endIndex = 0;
//
//        Map<Character, Integer> targetCharsetCountMap = new HashMap<>();
//        for (char targetChar : t.toCharArray()) {
//            Integer count = targetCharsetCountMap.getOrDefault(targetChar, 0);
//            targetCharsetCountMap.put(targetChar, ++count);
//        }
//
//        Map<Character, Integer> sourceCharsetCountMap = new HashMap<>();
//
//        int minBeginIndex = Integer.MIN_VALUE;
//        int minLength = Integer.MAX_VALUE;
//        int minEndLength = Integer.MAX_VALUE;
//        while (beginIndex <= endIndex && endIndex <= s.length()) {
//            if (checkSourceContainsTarget(sourceCharsetCountMap, targetCharsetCountMap)) {
//                int length = endIndex - beginIndex;
//                if (length < minLength) {
//                    minLength = length;
//                    minBeginIndex = beginIndex;
//                    minEndLength = endIndex;
//                }
//                Character beginCharset = s.charAt(beginIndex);
//                sourceCharsetCountMap.put(beginCharset, sourceCharsetCountMap.get(beginCharset) - 1);
//                beginIndex++;
//            } else if (endIndex == s.length()) {
//                break;
//            } else {
//                Character endCharset = s.charAt(endIndex);
//                Integer count = sourceCharsetCountMap.getOrDefault(endCharset, 0);
//                sourceCharsetCountMap.put(endCharset, ++count);
//                endIndex++;
//            }
//        }
//
//        if (minLength == Integer.MAX_VALUE) {
//            return "";
//        }
//        return s.substring(minBeginIndex, minEndLength);
//    }

    private static boolean checkSourceContainsTarget(Map<Character, Integer> sourceCharsetCountMap, Map<Character, Integer> targetCharsetCountMap) {
        for (Map.Entry<Character, Integer> sourceEntry : targetCharsetCountMap.entrySet()) {
            Character sourceKey = sourceEntry.getKey();
            int sourceCount = sourceEntry.getValue();

            if (!sourceCharsetCountMap.containsKey(sourceKey) || sourceCharsetCountMap.get(sourceKey) < sourceCount) {
                return false;
            }
        }
        return true;
    }
}


