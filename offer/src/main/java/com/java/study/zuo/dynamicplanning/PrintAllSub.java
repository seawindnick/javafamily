package com.java.study.zuo.dynamicplanning;

/**
 * <Description>
 * 打印字符串所有子序列
 * @author hushiye
 * @since 2020-08-09 17:27
 */
public class PrintAllSub {


    public static void printAllSub(String s){
        if (s == null || s.length() == 0){
            return;
        }
        char[] array = s.toCharArray();
        int curIndex = 0;
        String result = "";
        printAllSub(array,curIndex,result);
    }

    private static void printAllSub(char[] array, int curIndex, String result) {
        if (curIndex == array.length){
            System.out.println(result);
            return;
        }

        printAllSub(array,curIndex+1,result);
        printAllSub(array,curIndex+1,result+array[curIndex]);
    }

    public static void main(String[] args) {
        printAllSub("abc");
    }
}
