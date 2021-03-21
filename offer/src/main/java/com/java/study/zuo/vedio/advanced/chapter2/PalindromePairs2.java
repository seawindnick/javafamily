package com.java.study.zuo.vedio.advanced.chapter2;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 16:19
 */
public class PalindromePairs2 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordSet = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            res.addAll(findAll(words[i], i, wordSet));
        }

        return res;

    }

    private static Collection<? extends List<Integer>> findAll(String word, int index, HashMap<String, Integer> wordSet) {
        List<List<Integer>> res = new ArrayList<>();
        int[] rs = manacherrs(word);
        String reverse = reverse(word);
        Integer rest = wordSet.get("");
        //本身就是回文
        if (rest != null && rest != index && word.equals(reverse)) {
            addRecord(res, rest, index);
            addRecord(res, index, rest);
        }

        int mid = rs.length >> 1;
        for (int i = 1; i < mid; i++) {
            if (i - rs[i] == -1) {
                System.out.println(reverse.substring(0, mid - i));
                rest = wordSet.get(reverse.substring(0, mid - i));
                if (rest != null && rest != index) {
                    addRecord(res, rest, index);
                }

            }

        }

        for (int i = mid; i < rs.length; i++) {
            if (i + rs[i] == rs.length) {
                System.out.println(reverse.substring((mid << 1) - i));
                rest = wordSet.get(reverse.substring((mid << 1) - i));
                if (rest != null && rest != index) {
                    addRecord(res, index, rest);
                }

            }

        }

        return res;
    }

    private static void addRecord(List<List<Integer>> res, Integer left, int right) {
        List<Integer> list = new ArrayList<>();
        list.add(left);
        list.add(right);
        res.add(list);
    }

    private static String reverse(String word) {
        char[] array = word.toCharArray();
        int left = 0;
        int end = array.length - 1;
        while (left < end) {
            char leftIndex = array[left];
            array[left] = array[end];
            array[end] = leftIndex;
            left++;
            end--;

        }
        return String.valueOf(array);

    }

    private static int[] manacherrs(String word) {
        char[] mchrs = manachercs(word);
        int[] rs = new int[mchrs.length];
        int center = -1;
        int pr = -1;
        for (int i = 0; i < mchrs.length; i++) {
            rs[i] = pr > i ? Math.min(pr - i, rs[2 * center - i]) : 1;

            while (i + rs[i] < mchrs.length && i - rs[i] >= 0 && mchrs[i - rs[i]] == mchrs[i + rs[i]]) {
                rs[i]++;
            }

            if (i + rs[i] > pr) {
                pr = i + rs[i];
                center = i;
            }

        }
        return rs;
    }

    private static char[] manachercs(String word) {
        char[] array = new char[word.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 1 ? word.charAt(index++) : '#';
        }
        return array;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(JSONArray.toJSONString(palindromePairs(words)));
    }


}
