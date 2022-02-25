package leetCode;//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指字母相同，但排列不同的字符串。
//
//
//
// 示例 1:
//
//
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//
// 示例 2:
//
//
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//
//
//
// 提示:
//
//
// 1 <= s.length, p.length <= 3 * 104
// s 和 p 仅包含小写字母
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 579 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10438_FindAnagrams {

    public static void main(String[] args) {
        System.out.println(JSONArray.toJSONString(findAnagrams(
                "aabaa", "aabaa")));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] targetCount = new int[26];
        for (int index = 0; index < p.toCharArray().length; index++) {
            char character = p.charAt(index);
            targetCount[character - 'a']++;
        }

        int[] slideWindowsCount = new int[26];

        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < s.length(); index++) {
            char indexCharacter = s.charAt(index);
            slideWindowsCount[indexCharacter - 'a']++;

            if (checkMatch(targetCount, slideWindowsCount)) {
                result.add(index - p.length() + 1);
            }
            if (index >= p.length() - 1) {
                char outCharacter = s.charAt(index - p.length() + 1);
                slideWindowsCount[outCharacter - 'a']--;
            }
        }

        return result;
    }

    private static boolean checkMatch(int[] targetCount, int[] slideWindowsCount) {

        for (int index = 0; index < 26 ; index++) {
            if (targetCount[index] != slideWindowsCount[index]){
                return false;
            }
        }

        return true;
    }

}

