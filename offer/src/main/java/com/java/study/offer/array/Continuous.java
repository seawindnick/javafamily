package com.java.study.offer.array;

public class Continuous {

    public static void main(String[] args) {
        int[] arr = new int[5];

        Boolean checkContinuous = checkContinuous(arr);
    }

    private static Boolean checkContinuous(int[] arr) {



        if (arr == null || arr.length < 1) {
            return Boolean.FALSE;
        }
        //arr 数组已经排序，0代表大小王，放在最前面

        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }
        int gapNumber = 0;

        //小的数据位置，0后的位置
        int small = zeroCount;
        //大的数据位置
        int big = small + 1;

        while (big < arr.length){
            //存在对子
            if (arr[small] == arr[big]){
                return Boolean.FALSE;
            }
            // 如果big与small数据相差不为1，说明有间隙
            gapNumber = gapNumber + (arr[big] - arr[small] - 1);
            small = big;
            big ++;
        }

        return gapNumber < zeroCount;
    }
}
