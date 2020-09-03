package com.java.study.zuo.vedio.basic.chapter1;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

/**
 * <Description>
 * 快速排序
 *
 * @author hushiye
 * @since 2020-08-17 08:54
 */
public class QuickSort {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        quickSort2(arr, 0, arr.length - 1);


    }

    private static void quickSort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int random = l + (int) (Math.random() * (r - l + 1));
        //随机交换
        ArrayUtil.swap(arr, random, r);

        int[] result = partition(arr, l, r);
        quickSort2(arr, l, result[0] - 1);
        quickSort2(arr, result[1] + 1, r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int targetValue = arr[r];
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] > targetValue) {
                //最后一个不参与排序,  将大于的数字置换到 l 处，然后再对l处的数据进行评估
                ArrayUtil.swap(arr, l, --more);
            } else if (arr[l] < targetValue) {
                ArrayUtil.swap(arr, l++, ++less);
            } else {
                //等于不移动
                l++;
            }
        }

        //排完之后。将 使用大于targetValue第一个数字，替换最后一个数字
        ArrayUtil.swap(arr,more,r);
        return new int[]{less, more};
    }


    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        int L = startIndex;
        int R = endIndex;
        int targetValue = arr[endIndex];
        while (L < R) {

            while (L < R && arr[L] < targetValue) {
                L++;
            }
            ArrayUtil.swap(arr, R, L);

            while (L < R && arr[R] >= targetValue) {
                R--;
            }
            ArrayUtil.swap(arr, R, L);
        }

        arr[L] = targetValue;
        quickSort(arr, startIndex, L - 1);
        quickSort(arr, L + 1, endIndex);
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
//
        int[] arr = {1, 6, 5, 4, 7, 3, 2};
        quickSort(arr);
        System.out.println(JSONArray.toJSONString(arr));

//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            quickSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        quickSort(arr);
//        printArray(arr);
    }


}
