package com.java.study.zuo.vedio.advanced.chapter4;

import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-10 22:37
 */
public class SmallestMissNum {

    public static int SmallestMissNum(int[] array) {
       int left = 0;
       int end = array.length;
       while (left < end){
           if (array[left] == left + 1){
               left++;
           }else if (array[left] <= left || array[left] > end || array[left] - 1 == array[left]){
               /**
                *  array[left] <= left
                *  i 位置出现  array[i] <= left 时，说明 0-(i-1)位置 元素的顺序已经 按照 arr[j] = j+1 的顺序排列好了
                *  此时出现  array[i] <= left  说明
                *
                *
                */
               array[left] = array[--end];
           }else {
               ArrayUtil.swap(array,left,array[left]-1);
           }

       }
       return left+1;

    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1};
        System.out.println(SmallestMissNum(arr));
    }
}
