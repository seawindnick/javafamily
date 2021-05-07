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
public class Code_02_Palindrome_Pairs2 {

    public static List<List<Integer>> palindromePairs(String[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        Map<String, Integer> indexMap = buildIndexMap(arr);

        for (int i = 0; i < arr.length; i++) {
            list.addAll(findAllPalindromePairs(arr[i], i, indexMap));
        }

        return list;
    }

    private static List<List<Integer>> findAllPalindromePairs(String matchStr, int index, Map<String, Integer> indexMap) {
        List<List<Integer>> result = new ArrayList<>();
        int[] dp = getManacher(matchStr);
        String reverse = getReverse(matchStr);
        Integer res = indexMap.get("");

        // 表示本身就是回文， "" 加在前后都是一样的
        if (res != null && res != index && matchStr.equals(reverse)) {
            addRecord(result, res, index);
            addRecord(result, index, res);
        }

        int mid = dp.length >> 1;

        for (int i = 1; i < mid; i++) {
            if (i - dp[i] == -1) {
                // 原本：aabaacc  逆序：ccaabaa
                // # a # a # b # a # a # c # c
                // 执行到此处时说明当前节点到前方都是回文.如此时处于 b节点,那么 aabaa是一个回文对
                // 此时 mid = 7 即 原本字符串的长度
                // 逆序之后，后面的5个字符串是连续的，只需要将前面几个进行逆转即可
                // 当 i - dp[i] == -1 时，i 就是回文半径的中心点, i-1就是回文的长度
                // mid - 1 是中心位置的角标
                String value = reverse.substring(0, (mid - 1) - (i - 1));
                res = indexMap.get(value);
                if (res != null && res != index) {
                    addRecord(result, res, index);
                }

            }
        }

        /**
         * 原文后半截是回文
         * 原本：aabaacc  逆序：ccaabaa
         * # a # a # b # a # a # c # c
         *
         *
         *
         *
         *
         */
        for (int i = mid + 1; i < dp.length; i++) {
            if (i + dp[i] == dp.length) {
                String value = reverse.substring((mid << 1) - i);
                if (!Objects.equals(value, matchStr) && indexMap.containsKey(value)) {
                    addRecord(result, index, indexMap.get(value));
                }
            }

        }

        return result;
    }

    private static String getReverse(String matchStr) {
        char[] array = new char[matchStr.length()];
        int curIndex = 0;
        while (curIndex < matchStr.length()) {
            array[curIndex] = matchStr.charAt(matchStr.length() - 1 - curIndex);
            curIndex++;
        }
        return String.valueOf(array);
    }

    private static void addRecord(List<List<Integer>> result, Integer res, int index) {
        List<Integer> list = new ArrayList<>();
        list.add(res);
        list.add(index);
        result.add(list);
    }

    /**
     * 获取回文数信息
     *
     * @param matchStr
     * @return
     */
    private static int[] getManacher(String matchStr) {
        char[] array = getManacherArray(matchStr);
        int maxRight = -1;
        int center = -1;

        int[] dp = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            dp[index] = maxRight > index ? Math.min(dp[2 * center - index], maxRight - index) : 1;
            while (index + dp[index] < array.length && index - dp[index] > -1) {
                if (array[index + dp[index]] == array[index - dp[index]]) {
                    dp[index]++;
                } else {
                    break;
                }
            }

            if (dp[index] + index > maxRight) {
                maxRight = dp[index] + index;
                center = index;
            }
        }

        return dp;
    }

    private static char[] getManacherArray(String matchStr) {
        char[] array = new char[matchStr.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = ((i & 1) == 0) ? '#' : matchStr.charAt(index++);
        }
        return array;
    }


    private static Map<String, Integer> buildIndexMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aabaacc"};
        System.out.println(JSONArray.toJSONString(palindromePairs(words)));

        System.out.println(com.java.study.answer.zuo.dadvanced.advanced_class_02.Code_02_Palindrome_Pairs.palindromePairs(words));
    }
}