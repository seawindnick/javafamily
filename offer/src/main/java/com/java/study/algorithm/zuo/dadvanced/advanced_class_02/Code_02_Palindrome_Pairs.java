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
public class Code_02_Palindrome_Pairs {

    public static List<Integer[]> Palindrome_Pairs(String[] arr) {

        List<Integer[]> list = new ArrayList<>();
        Map<String, Integer> indexMap = buildIndexMap(arr);

        for (int i = 0; i < arr.length; i++) {

            List<String> target = findPalindromePairs(arr[i]);
            if (target != null && !target.isEmpty()) {
                for (String result : target) {
                    if (indexMap.containsKey(result) && indexMap.get(result) != i) {
                        list.add(new Integer[]{i, indexMap.get(result)});
                    }
                }
            }
        }

        return list;
    }

    private static List<String> findPalindromePairs(String matchStr) {
        List<String> targetList = new ArrayList<>();

        char[] array = getMach(matchStr);

        int maxRight = -1;
        int centerIndex = -1;
        int[] palind = new int[array.length];
        int max = -1;

        int index = 1;

        //无脑添加整体逆转
        targetList.add(reverse(matchStr));

        while (index < array.length) {
            palind[index] = 1;
            if (maxRight > index) {
                palind[index] = Math.min(palind[2 * centerIndex - index], maxRight - index);
            }

            while (index - palind[index] >= 0 && index + palind[index] < array.length && array[index - palind[index]] == array[index + palind[index]]) {
                palind[index]++;
            }

            if (index + palind[index] >= maxRight) {
                maxRight = index + palind[index];
            }

            max = Math.max(max, palind[index]);

            //说明当前位置到 头部 有回文部分
            if (index - palind[index] + 1 == 0 && index + palind[index] - 1 != array.length + 1) {
                String value = reversePreHalf(array, index, palind[index]);
                targetList.add(value);
            }

            if (index + palind[index] + 1 == array.length - 1 && index - palind[index] + 1 != 0) {
                String value = reverseAfterHalf(array, index, palind[index]);
                targetList.add(value);
            }

        }

        return targetList;
    }

    private static String reversePre(String matchStr) {
        char[] chars = new char[matchStr.length()];

        int curIndex = 0;
        while (curIndex < matchStr.length()) {
            chars[curIndex] = matchStr.charAt(matchStr.length() - 1 - curIndex);
        }
        return String.valueOf(chars);

    }

    private static String reverseAfterHalf(char[] array, int index, int palindLength) {
        int maxLeftIndex = index - palindLength + 1;
        int copyStartIndex = maxLeftIndex - 1;
        return reverseHalf(array, copyStartIndex, 0, palindLength);
    }

    private static String reverseHalf(char[] array, int copyStartIndex, int endIndex, int palindLength) {
        char[] result = new char[(array.length - (2 * palindLength - 1)) / 2];

        int curIndex = 0;
        while (copyStartIndex >= endIndex) {
            if ((copyStartIndex & 1) == 1) {
                result[curIndex++] = array[copyStartIndex];
            }
            copyStartIndex--;

        }
        return String.valueOf(result);
    }

    /**
     * 逆转前半部分
     * # 1 # 2 # 3 # 2 # 1 # 5
     * <p>
     * 以 3 为中心的形成的回文，已经触达到头部位置，因此将 # 5 形成回文 ，然后去除#号即可
     *
     * @param array
     * @param index
     * @param palindLength
     * @return
     */
    private static String reversePreHalf(char[] array, int index, int palindLength) {
        int maxRightIndex = index + palindLength;
        int endIndex = array.length - 1;
        return reverseHalf(array, endIndex, maxRightIndex, palindLength);
    }

    private static String reverse(String matchStr) {
        char[] chars = new char[matchStr.length()];
        int curIndex = 0;
        while (curIndex < chars.length) {
            chars[curIndex] = matchStr.charAt(matchStr.length() - 1 - curIndex);
            curIndex++;
        }
        return String.valueOf(chars);
    }

    private static char[] getMach(String matchStr) {
        char[] array = new char[matchStr.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 0 ? '#' : matchStr.charAt(curIndex++);
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
        String[] words = new String[]{"bat", "tab", "cat"};
        System.out.println(JSONArray.toJSONString(Palindrome_Pairs(words)));
    }
}