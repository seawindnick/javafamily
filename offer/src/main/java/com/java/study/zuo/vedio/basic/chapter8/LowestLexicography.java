package com.java.study.zuo.vedio.basic.chapter8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-29 21:23
 */
public class LowestLexicography {

    public static String lowestLexicography(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr,new Compare());
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }

        return builder.toString();

    }


    public static class Compare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestLexicography(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestLexicography(strs2));

    }
}
