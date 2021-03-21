package com.java.study.zuo.vedio.advanced.chapter2;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 16:19
 */
public class PalindromePairs {

    public static List<Integer[]> palindromePairs(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        List<Integer[]> targetList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
//            String reverStr = getReverStr(str);
//
//            if (!Objects.equals(str, reverStr) && map.containsKey(reverStr)) {
//                targetList.add(new Integer[]{i, map.get(reverStr)});
//            }

            char[] manacherStr = getManacherStr(str);

            Integer[][] next = manacherStartWithFirst(manacherStr);

            Integer[] startWithFirstNext = next[0];
            for (Integer index : startWithFirstNext) {
                if (index == null) {
                    break;
                }

                String searchReverse = searchReverse(manacherStr, index, manacherStr.length - 1);

                if (map.containsKey(searchReverse)) {
                    targetList.add(new Integer[]{i, map.get(searchReverse)});
                }
            }
            Integer[] endWithLastNext = next[1];
            for (Integer index : endWithLastNext) {
                if (index == null) {
                    break;
                }
                String searchReverse = searchReverse(manacherStr, 0, manacherStr.length - 1 - index);
                if (map.containsKey(searchReverse)) {
                    targetList.add(new Integer[]{i, map.get(searchReverse)});
                }

            }
        }
        return targetList;
    }

    private static String searchReverse(char[] manacherStr, Integer index, int endIndex) {
        char[] target = new char[(endIndex - index) / 2 + 1];
        int curIndex = 0;

        for (int i = endIndex; i >= index; i--) {
            if ((i & 1) == 1) {
                target[curIndex++] = manacherStr[i];
            }
        }

        return String.valueOf(target);
    }

    private static Integer[][] manacherStartWithFirst(char[] manacherStr) {

        Integer[] startWithFirstNext = new Integer[manacherStr.length];
        Integer[] endWithLastNext = new Integer[manacherStr.length];

        int[] next = new int[manacherStr.length];
        int c = -1;
        int r = Integer.MIN_VALUE;

        int startIndex = 0;
        int endIndex = 0;


        for (int i = 0; i < manacherStr.length; i++) {
            next[i] = i < r ? Math.min(r - i, next[2 * c - i]) : 1;

            while (i + next[i] < manacherStr.length && i - next[i] > -1) {
                if (manacherStr[i + next[i]] == manacherStr[i - next[i]]) {
                    next[i]++;
                } else {
                    break;
                }
            }

            if (next[i] + i > r) {
                r = next[i] + i;
                c = i;
            }
            if (i - (next[i] - 1) == 0) {
                startWithFirstNext[startIndex++] = 2 * next[i] - 1;
            }

            if (i + (next[i] - 1) == manacherStr.length - 1) {
                endWithLastNext[endIndex++] = 2 * next[i] - 1;
            }
        }

        return new Integer[][]{startWithFirstNext, endWithLastNext};
    }

    private static char[] getManacherStr(String str) {
        char[] array = str.toCharArray();
        char[] targetArray = new char[array.length * 2 + 1];
        int curIndex = 0;
        int index = 0;
        while (curIndex < targetArray.length) {
            targetArray[curIndex] = curIndex == (2 * index + 1) ? array[index++] : '#';
            curIndex++;
        }
        return targetArray;
    }

    private static String getReverStr(String str) {
        char[] array = str.toCharArray();
        int left = 0;
        int end = array.length - 1;
        while (left < end) {
            char temp = array[left];
            array[left] = array[end];
            array[end] = temp;
            left++;
            end--;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(JSONArray.toJSONString(palindromePairs(words)));
    }
}
