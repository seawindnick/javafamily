package com.java.study.zuo.sort.QuickSort;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * 荷兰国旗
 * 将 小于number的数据放在左边，大于number的数据放在右边，等于number的数据放在中间
 */
public class NetherlandsFlag {


    public static int[] partition(int[] arr, int L, int R, int number) {
        int less = L - 1;
        int more = R + 1;

        int currentIndex = L;
        while (currentIndex < more) {
            if (arr[currentIndex] < number) {
                ArrayUtil.swap(arr, ++less, currentIndex++);
            } else if (arr[currentIndex] > number) {
                ArrayUtil.swap(arr, --more, currentIndex);
            } else {
                currentIndex++;
            }
        }
        return new int[]{less + 1, more - 1};
    }


    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
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

    public static void main(String[] args) {
        int[] test = generateArray();

//        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
//        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

        System.out.println(JSONArray.toJSONString(test));

    }

}
