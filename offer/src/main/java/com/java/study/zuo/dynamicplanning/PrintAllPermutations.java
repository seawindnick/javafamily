package com.java.study.zuo.dynamicplanning;

import java.util.HashSet;
import java.util.Set;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 17:34
 */
public class PrintAllPermutations {


    public static void printAllPermutations(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        int curIndex = 0;
        Set<String> hashSet = new HashSet<>();
        printAllPermutations(str.toCharArray(), curIndex,hashSet);

        hashSet.forEach(s -> System.out.println(s));

    }

    private static void printAllPermutations(char[] arr, int curIndex, Set<String> hashSet) {
        if (curIndex == arr.length) {
            hashSet.add(String.valueOf(arr));
        } else {
            for (int i = curIndex; i < arr.length; i++) {
                swap(arr, i, curIndex);
                printAllPermutations(arr, curIndex + 1,hashSet);
                //完事之后 还原
//                swap(arr, i, curIndex);
            }
        }
    }

    private static void swap(char[] arr, int i, int curIndex) {
        char old = arr[i];
        arr[i] = arr[curIndex];
        arr[curIndex] = old;
    }

    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process1(chs, i + 1);
            swap(chs, i, j);
        }
    }

    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        //记录当前位置已经处理过的元素，处理过了就不再进行处理了
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

//
//    public static void main(String[] args) {
//        printAllPermutations("123456");
//    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("======");
        printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "acc";
        printAllPermutations(test2);
        System.out.println("======");
        printAllPermutations2(test2);
        System.out.println("======");
    }

}
