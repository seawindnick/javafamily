package com.java.study.zuo.vedio.advanced.chapter1;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-31 11:00
 */
public class TowSum {

    public static int[] twoSum(int[] arr, int targetValue) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int shouldValue = targetValue - arr[i];
            if (map.containsKey(shouldValue)) {
                return new int[]{map.get(shouldValue), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    /**
     * 返回记录信息
     *
     * @param arr
     * @param targetValue
     * @return
     */
    public static int[] twoSum2(int[] arr, int targetValue) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        //堆排序
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            heapInsert(sortArr, i, arr);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapfiy(sortArr, 0, i);
            arr[i] = sortArr[i];
        }


        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (arr[leftIndex] + arr[rightIndex] == targetValue) {
                return new int[]{arr[leftIndex], arr[rightIndex]};
            }
            if (arr[leftIndex] + arr[rightIndex] > targetValue) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return new int[]{};
    }


    /**
     * 返回位置信息
     *
     * @param arr
     * @param targetValue
     * @return
     */
    public static int[] twoSum3(int[] arr, int targetValue) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int[] indexArray = new int[arr.length];

        //堆排序
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexArray[i] = i;
            heapInsert(sortArr, i, arr, indexArray);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapfiy(sortArr, 0, i, indexArray);
            arr[i] = sortArr[i];
        }


        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (arr[leftIndex] + arr[rightIndex] == targetValue) {
                return new int[]{indexArray[leftIndex], indexArray[rightIndex]};
            }
            if (arr[leftIndex] + arr[rightIndex] > targetValue) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return new int[]{};
    }

    private static void heapfiy(int[] sortArr, int startIndex, int endIndex, int[] indexArray) {
        ArrayUtil.swap(sortArr, 0, endIndex);
        ArrayUtil.swap(indexArray, 0, endIndex);

        int leftIndex = startIndex * 2 + 1;

        while (leftIndex <= endIndex - 1) {

            int subMax = (leftIndex + 1) > endIndex - 1 ? leftIndex : sortArr[leftIndex] > sortArr[leftIndex + 1] ? leftIndex : leftIndex + 1;
            int replaceIndex = sortArr[subMax] > sortArr[startIndex] ? subMax : startIndex;

            if (startIndex == replaceIndex) {
                break;
            }

            ArrayUtil.swap(sortArr, startIndex, replaceIndex);
            ArrayUtil.swap(indexArray, startIndex, replaceIndex);
            startIndex = replaceIndex;
            leftIndex = startIndex * 2 + 1;
        }

    }

    private static void heapInsert(int[] sortArr, int index, int[] arr, int[] indexArray) {
        sortArr[index] = arr[index];
        int parentIndex = (index - 1) / 2;
        while (index != 0) {
            if (sortArr[parentIndex] < sortArr[index]) {
                ArrayUtil.swap(sortArr, parentIndex, index);
                ArrayUtil.swap(indexArray, parentIndex, index);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            } else {
                return;
            }
        }
    }

    /**
     * 往下沉
     *
     * @param sortArr
     * @param startIndex
     * @param endIndex
     */
    private static void heapfiy(int[] sortArr, int startIndex, int endIndex) {
        ArrayUtil.swap(sortArr, 0, endIndex);

        int leftIndex = startIndex * 2 + 1;

        while (leftIndex <= endIndex - 1) {

            int subMax = (leftIndex + 1) > endIndex - 1 ? leftIndex : sortArr[leftIndex] > sortArr[leftIndex + 1] ? leftIndex : leftIndex + 1;
            int replaceIndex = sortArr[subMax] > sortArr[startIndex] ? subMax : startIndex;

            if (startIndex == replaceIndex) {
                break;
            }

            ArrayUtil.swap(sortArr, startIndex, replaceIndex);
            startIndex = replaceIndex;
            leftIndex = startIndex * 2 + 1;
        }
    }


    private static void heapInsert(int[] sortArr, int index, int[] arr) {
        sortArr[index] = arr[index];
        int parentIndex = (index - 1) / 2;
        while (index != 0) {
            if (sortArr[parentIndex] < sortArr[index]) {
                ArrayUtil.swap(sortArr, parentIndex, index);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            } else {
                return;
            }
        }
    }


    /**
     * 获取不重复的数据
     *
     * @param arr
     * @return
     */
    public static List<Integer[]> allNotRepeat(int[] arr, int targer) {

        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        List<Integer[]> lists = new ArrayList<>();

        int[] indexArray = new int[arr.length];

        //堆排序
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexArray[i] = i;
            heapInsert(sortArr, i, arr, indexArray);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapfiy(sortArr, 0, i, indexArray);
            arr[i] = sortArr[i];
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {

            if (arr[leftIndex] + arr[rightIndex] > targer) {
                rightIndex--;
            } else if (arr[leftIndex] + arr[rightIndex] < targer) {
                leftIndex++;
            } else {
                if (leftIndex == 0 || arr[leftIndex] != arr[leftIndex - 1]) {
                    lists.add(new Integer[]{indexArray[leftIndex], indexArray[rightIndex]});
                    leftIndex++;
                } else {
                    leftIndex++;
                    rightIndex--;

                }
            }

        }

        return lists;
    }


    private static int[] threeSum(int[] arr, int targetNum) {

        for (int i = 0; i < arr.length; i++) {
            int indexValue = arr[i];
            if (targetNum > indexValue) {
                int[] temp = new int[arr.length - i - 2];
                int curIndex = 0;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    temp[curIndex++] = arr[j];
                }

                int[] tempArr = twoSum2(arr, targetNum - indexValue);
                if (tempArr != null && tempArr.length != 0) {
                    return new int[]{tempArr[0], tempArr[1], indexValue};
                }
            }

        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 9, 7, 2};
        System.out.println(JSONArray.toJSONString(threeSum(arr, 20)));
    }


}
