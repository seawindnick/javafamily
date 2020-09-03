package com.java.study.zuo.vedio.basic.chapter2;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 10:29
 */
public class BFPrt {
//
//    private static int[] getKValue(int[] array, int k) {
//        if (k < 1 || k > array.length) {
//            return array;
//        }
//        int minKth = getMinKthByBFPRT(array, k);
//        int[] result = new int[k];
//        int index = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < minKth) {
//                result[index++] = array[i];
//            }
//        }
//
//        for (; index < result.length; index++) {
//            result[index] = minKth;
//        }
//        return result;
//    }
//
//    private static int getMinKthByBFPRT(int[] array, int k) {
//        int[] copyArr = Arrays.copyOf(array, array.length);
//        return select(copyArr, 0, copyArr.length - 1, k - 1);
//
//    }
//
//    private static int select(int[] arr, int begin, int end, int i) {
//        if (begin == end) {
//            return arr[begin];
//        }
//        int povit = medianOfMedians(arr, begin, end);
//        int[] pivotRange = partition(arr, begin, end, povit);
//        if (i >= pivotRange[0] && i <= pivotRange[1]) {
//            return arr[i];
//        } else if (pivotRange[0] > i) {
//            return select(arr, begin, pivotRange[0] - 1, i);
//        } else {
//            return select(arr, pivotRange[1] + 1, end, i);
//        }
//    }
//
//    private static int medianOfMedians(int[] arr, int begin, int end) {
//        int num = end - begin + 1;
//        int offset = num % 5 == 0 ? 0 : 1;
//        int[] mArr = new int[num / 5 + offset];
//        for (int i = 0; i < mArr.length; i++) {
//            int beginI = begin + i * 5;
//            int endI = beginI + 4;
//            mArr[i] = getMedain(arr, beginI, Math.min(endI, end));
//        }
//        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
//
//    }
//
//    private static int getMedain(int[] arr, int beginI, int end) {
//        insertSort(arr, beginI, end);
//        int mid = beginI + (end - beginI) / 2;
//        return arr[mid];
//    }
//
//    private static void insertSort(int[] arr, int beginI, int end) {
//        for (int i = beginI + 1; i < end; i++) {
//            for (int j = i; j > beginI; j--) {
//                if (arr[j + 1] > arr[j]) {
//                    ArrayUtil.swap(arr, j, j + 1);
//                } else {
//                    break;
//                }
//            }
//
//        }
//    }


//    private static int[] partition(int[] arr, int begin, int end, int povit) {
//        int more = end + 1;
//        int less = begin - 1;
//
//        int index = begin;
//        while (index < more) {
//            if (arr[index] == povit) {
//                index++;
//            } else if (arr[index] > povit) {
//                ArrayUtil.swap(arr, index, --more);
//            } else {
//                ArrayUtil.swap(arr, ++less, index++);
//            }
//        }
//        return new int[]{less + 1, more - 1};
//    }


    public static int getKValue(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("数组容量不够");
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int targetK = k - 1;
        int[] copyArray = new int[arr.length];

        int value = getIndexKVale(arr, startIndex, endIndex, targetK, copyArray);
        return value;
    }

    /**
     * @param arr        目标数组
     * @param startIndex 开始位置
     * @param endIndex   结束位置
     * @param targetK    目标位置
     * @param copyArray
     * @return
     */
    private static int getIndexKVale(int[] arr, int startIndex, int endIndex, int targetK, int[] copyArray) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }
        //获取所有的中位数集合信息
        int calculateLength = (endIndex - startIndex + 1);
        int centerValueLength = calculateLength % 5 == 0 ? calculateLength / 5 : (calculateLength / 5) + 1;
        int[] centerArrValue = new int[centerValueLength];
        for (int i = 0; i < centerValueLength; i++) {
            int centerStartIndex = startIndex + i * 5;
            // 取 startIndex + (i + 1) * 5 - 1 与 endIndex 较小者
            int centerEndIndex = Math.min(startIndex + (i + 1) * 5 - 1, endIndex);
            //使用归并排序，获取中位数信息
            centerArrValue[i] = getCenterValue(arr, centerStartIndex, centerEndIndex, copyArray);
        }
        // 获取各组中位数的中位数
        int centerValue = getCenterValue(centerArrValue, 0, centerArrValue.length - 1, new int[centerArrValue.length]);
        // 使用荷兰国旗排序方式，一次排一排数据
        int[] indexArr = quickSort(arr, centerValue, startIndex, endIndex);
        if (indexArr[0] <= targetK && indexArr[1] >= targetK) {
            return arr[targetK];
        } else if (indexArr[0] > targetK) {
            return getIndexKVale(arr, startIndex, indexArr[0] - 1, targetK, copyArray);
        } else {
            return getIndexKVale(arr, indexArr[1] + 1, endIndex, targetK, copyArray);
        }
    }

    private static int getCenterValue(int[] arr, int centerStartIndex, int centerEndIndex, int[] copyArray) {
        mergeSort(arr, centerStartIndex, centerEndIndex, copyArray);
        int midIndex = centerStartIndex + (centerEndIndex - centerStartIndex) / 2;

        return arr[midIndex];
    }


    private static void mergeSort(int[] arr, int startIndex, int endIndex, int[] copyArray) {
        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        mergeSort(arr, startIndex, midIndex, copyArray);
        mergeSort(arr, midIndex + 1, endIndex, copyArray);
        merge(arr, startIndex, midIndex, endIndex, copyArray);
    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] copyArray) {
        int l = startIndex;
        int r = midIndex + 1;
        int copyStartIndex = startIndex;
        while (l <= midIndex && r <= endIndex) {
            copyArray[copyStartIndex++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }

        while (l <= midIndex) {
            copyArray[copyStartIndex++] = arr[l++];
        }
        while (r <= endIndex) {
            copyArray[copyStartIndex++] = arr[r++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = copyArray[i];
        }
    }


    private static int[] quickSort(int[] arr, int centerValue, int startIndex, int endIndex) {
        int less = startIndex - 1;
        int more = endIndex + 1;

        int curIndex = startIndex;
        while (curIndex < more) {
            if (arr[curIndex] == centerValue) {
                curIndex++;
            } else if (arr[curIndex] < centerValue) {
                ArrayUtil.swap(arr, curIndex++, ++less);
            } else {
                ArrayUtil.swap(arr, curIndex, --more);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
//        int[] array = new int[]{8, 2, 4, 6, 8, 9, 3, 2, 1, 5, 7, 9, 0};
//        int value = getKValue(array, 5);
//        System.out.println(value);
//
        for (int i = 0; i < 12; i++) {
            int[] array = new int[]{8, 2, 4, 6, 8, 9, 3, 2, 1, 5, 7, 9, 0};
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(copy);

            int value = getKValue(array, i + 1);
            int targetValue = copy[i];
            System.out.println(value == targetValue);

        }
    }

//    public static void main(String[] args) {
//        int[] array = new int[]{8, 2, 4, 6, 8, 9, 3, 2, 1, 5, 7, 9, 0};
//        int[] result = getKValue(array, 2);
//        System.out.println(JSONArray.toJSONString(result));
//    }


}
