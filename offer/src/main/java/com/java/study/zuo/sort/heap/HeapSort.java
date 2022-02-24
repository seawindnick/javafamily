package com.java.study.zuo.sort.heap;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        ArrayUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            ArrayUtil.swap(arr, 0, --size);
        }
    }

    /**
     * @param arr
     * @param index
     * @param size
     */
    private static void heapify(int[] arr, int index, int size) {
        int leftIndex = index * 2 + 1;

        //最后一列不参与调整
        while (leftIndex < size) {
            //获取左右节点最大值节点位置，注意 右节点可能越界
            int targetIndex = (leftIndex + 1) < size && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            //判断左右节点最大值 与 父节点比较，结果是值大的元素位置
            targetIndex = arr[targetIndex] > arr[index] ? targetIndex : index;

            //如果此时父节点是大的，那么子节点不需要再调整
            if (targetIndex == index) {
                break;
            }

            //如果父节点不是最大，节点下沉，再对左节点/右节点数据进行下沉
            ArrayUtil.swap(arr, targetIndex, index);
            index = targetIndex;
            leftIndex = index * 2 + 1;
        }
    }

    /**
     * 构建最大堆
     *
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

}
