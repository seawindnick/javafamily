package com.java.study.zuo.vedio.basic.chapter7;

import java.util.HashSet;
import java.util.Set;

/**
 * <Description>
 * 全排列
 * @author hushiye
 * @since 2020-08-26 23:36
 */
public class Permutations {

    public static void permutations(String str){
        if (str == null || str.length() < 1){
            return;
        }

        char[] array = str.toCharArray();
        int startIndex = 0;
        int endIndex = array.length-1;
        permutations(array,startIndex,endIndex);

    }

    private static void permutations(char[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex){
            System.out.println(new String(array));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = startIndex; i <= endIndex ; i++) {
            char changeChar = array[i];
            if (!set.contains(changeChar)){
                swap(array,startIndex,i);
                permutations(array,startIndex+1,endIndex);
                swap(array,startIndex,i);
                set.add(changeChar);
            }
        }
    }

    private static void swap(char[] array, int startIndex, int tempIndex) {
        char temp = array[startIndex];
        array[startIndex] = array[tempIndex];
        array[tempIndex] = temp;
    }

    public static void main(String[] args) {
        permutations("acc");
    }
}
