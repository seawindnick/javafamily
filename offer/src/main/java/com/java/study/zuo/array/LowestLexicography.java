package com.java.study.zuo.array;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <Description>
 * 字符串类型数组排序，形成最低字典序
 *
 * @author hushiye
 * @since 2020-08-05 22:56
 */
public class LowestLexicography {

    public static String findLowestLexicography(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr, new StringComparator());

        return buildString(arr);
    }

    //选择排序
    public static String findLowestLexicography2(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int length = arr.length - 1;
        for (int i = 0; i <= arr[i].length() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= length; j++) {
                if (lastMin(arr,minIndex,j)){
                    minIndex = j;
                }
            }
            ArrayUtil.swap(arr,minIndex,i);
        }

        return buildString(arr);
    }

    private static String buildString(String[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }


    private static boolean lastMin(String[] arr, int minIndex, int j) {
        String str1 = arr[minIndex] + arr[j];
        String str2 =  arr[j] + arr[minIndex];
        return str2.compareTo(str1) < 0;
    }


    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str1.compareTo(str2);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"ert", "asc", "ac", "ca"};
        System.out.println(findLowestLexicography2(arr));
    }


}
