package com.java.study.zuo.sort;

public class ArrayUtil {

    public static void swap(int[] arr,int oldIndex,int targetIndex){
        int temp = arr[oldIndex];
        arr[oldIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }
}
