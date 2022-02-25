package leetCode;//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划
// 👍 1104 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10139_WordBreak {
    public static void main(String[] args) {
//        "leetcode"
//                ["leet","code"]
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak2(s, wordDict));
    }

    private static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        //记录每个位置的单词是否可以进行拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //循环每一个位置节点
        for (int index = 1; index <= s.length(); index++) {
            //定义断点
            for (int cutIndex = 0; cutIndex < index; cutIndex++) {
                // 断点前面可以是可以进行拆分的
                if (dp[cutIndex] && wordSet.contains(s.substring(cutIndex, index))) {
                    dp[index] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

//    public class Solution {
//        public boolean wordBreak(String s, List<String> wordDict) {
//            Set<String> wordDictSet = new HashSet(wordDict);
//            boolean[] dp = new boolean[s.length() + 1];
//            dp[0] = true;
//            for (int i = 1; i <= s.length(); i++) {
//                for (int j = 0; j < i; j++) {
//                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[s.length()];
//        }
//    }

    /**
     * @param s
     * @param wordDict
     * @return
     */


    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        Set<String> wordSet = new HashSet<>(wordDict);

        int startIndex = 0;
        int stopIndex = s.length() - 1;
        return wordBreak(s, wordSet, startIndex, stopIndex);
    }

    private static boolean wordBreak(String s, Set<String> wordSet, int startIndex, int stopIndex) {
        if (startIndex > stopIndex) {
            return false;
        }

        String str = buildStr(s, startIndex, stopIndex);
        if (wordSet.contains(str)) {
            return true;
        }

        for (int index = startIndex; index < stopIndex; index++) {
            if (wordBreak(s, wordSet, startIndex, index) && wordBreak(s, wordSet, index + 1, stopIndex)) {
                return true;
            }
        }
        return false;
    }

    private static String buildStr(String s, int startIndex, int stopIndex) {
        String str = "";
        while (startIndex <= stopIndex) {
            str = str + s.charAt(startIndex);
            startIndex++;
        }
        return str;
    }
}


