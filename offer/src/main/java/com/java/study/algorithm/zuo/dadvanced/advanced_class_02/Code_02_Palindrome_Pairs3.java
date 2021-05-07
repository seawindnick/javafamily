package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * 链表words中都是不同的词，如果其中str1加str2之后是回文串， 则str1的位置和str2的位置我们需要收集。
 * 比如
 * words = ["bat", "tab", "cat"]
 * 返回[[0, 1], [1, 0]]
 * words = ["abcd", "dcba", "lls", "s", "sssll"] 返回[[0, 1], [1, 0], [3, 2], [2, 4]]
 */
public class Code_02_Palindrome_Pairs3 {

    public static List<List<Integer>> palindromePairs(String[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        Map<String, Integer> indexMap = buildIndexMap(arr);

        for (int i = 0; i < arr.length; i++) {
            list.addAll(findAllPalindromePairs(arr[i], i, indexMap));
        }

        return list;
    }

    private static List<List<Integer>> findAllPalindromePairs(String matchStr, int index, Map<String, Integer> indexMap) {
        List<List<Integer>> list = new ArrayList<>();

        String reverse = getReverse(matchStr);
        Integer res = indexMap.get("");
        if (res != null && res != index && reverse.equals(matchStr)) {
            addRecord(list, index, res);
            addRecord(list, res, index);
        }


        int[] dp = getNext(matchStr);

        int midIndex = dp.length / 2;

        int reverseLength = reverse.length();

        for (int i = 1; i < midIndex; i++) {
            //说明以 i 为回文中心的回文串已经触达到头节点位置
            if (i - dp[i] == -1) {
                //以当前节点为中心的回文长度
                int palindromeLength = dp[i] - 1;
                String value = reverse.substring(0, reverseLength - 1 - (palindromeLength - 1));
                res = indexMap.get(value);
                if (res != null && !matchStr.equals(value)) {
                    addRecord(list, res, index);
                }
            }
        }

        for (int i = midIndex + 1; i < dp.length; i++) {
            if (i + dp[i] == dp.length) {
                //以当前节点为中心的回文长度
                // 原字符串中以当前位置为中心的后面是会文串，长度为 palindromeLength，那么其逆序列中，0 ～ palindromeLength-1 为回文串，只需要将你序列中 palindromeLength 之后的字串截取即可
                int palindromeLength = dp[i] - 1;

                String value = reverse.substring(palindromeLength);

                res = indexMap.get(value);
                if (res != null && !matchStr.equals(value)) {
                    addRecord(list, index, res);
                }

            }

        }
        return list;

    }

    private static void addRecord(List<List<Integer>> list, int index, Integer res) {
        List<Integer> resList = new ArrayList<>();
        resList.add(index);
        resList.add(res);
        list.add(resList);
    }

    private static String getReverse(String matchStr) {
        char[] arr = new char[matchStr.length()];
        int index = 0;
        while (index < matchStr.length()) {
            arr[index] = matchStr.charAt(arr.length - 1 - index);
            index++;
        }
        return String.valueOf(arr);
    }

    /**
     * 获取马拉车回文数量
     *
     * @param matchStr
     * @return
     */
    private static int[] getNext(String matchStr) {
        char[] manacher = getManacher(matchStr);
        int[] dp = new int[manacher.length];
        int centerIndex = -1;
        int maxRight = -1;

        for (int index = 0; index < manacher.length; index++) {
            dp[index] = maxRight > index ? Math.min(dp[2 * centerIndex - index], maxRight - index) : 1;

            while (index - dp[index] > -1 && index + dp[index] < manacher.length) {
                if (manacher[index - dp[index]] == manacher[index + dp[index]]) {
                    dp[index]++;
                } else {
                    break;
                }
            }

            if (index + dp[index] > maxRight) {
                maxRight = index + dp[index];
                centerIndex = index;
            }

        }

        return dp;

    }

    private static char[] getManacher(String matchStr) {
        char[] arr = new char[matchStr.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i & 1) == 0 ? '#' : matchStr.charAt(curIndex++);
        }

        return arr;
    }


    private static Map<String, Integer> buildIndexMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map;
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        String[] words = new String[]{"abcd", "dcba"};
        System.out.println(JSONArray.toJSONString(palindromePairs(words)));

        System.out.println(com.java.study.answer.zuo.dadvanced.advanced_class_02.Code_02_Palindrome_Pairs.palindromePairs(words));
    }
}