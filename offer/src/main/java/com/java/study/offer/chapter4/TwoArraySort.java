package com.java.study.offer.chapter4;

import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;
import java.util.Objects;

public class TwoArraySort {


    public static void main(String[] args) {
        Integer[] arr1 = new Integer[15];
        arr1[0] = 5;
        arr1[1] = 8;
        arr1[2] = 10;

        Integer[] arr2 = new Integer[6];
        arr2[0] = 3;
        arr2[1] = 4;

        sort(arr1, arr2);

        System.out.println(JSONArray.toJSONString(arr1));

    }

    private static void sort(Integer[] firstArr, Integer[] secondArr) {
        if (Objects.isNull(firstArr) || Objects.isNull(secondArr)) {
            return;
        }

        Integer[] longArr = firstArr;
        Integer[] shortArr = secondArr;
        if (firstArr.length < secondArr.length) {
            longArr = secondArr;
            shortArr = firstArr;
        }

        int longArrEffectiveLength = (int) Arrays.stream(longArr).filter(Objects::nonNull).count();
        int shortArrEffectiveLength = (int) Arrays.stream(shortArr).filter(Objects::nonNull).count();

        int totalLength = longArrEffectiveLength + shortArrEffectiveLength;

        if (totalLength > longArr.length) {
            return;
        }

        //理论排序后最后一位数据所在位置角标
        int totalEndIndex = totalLength - 1;
        int longEffectiveEndIndex = longArrEffectiveLength - 1;
        int shortEffectiveEndIndex = shortArrEffectiveLength - 1;

        for (int longEndIndex = longEffectiveEndIndex; longEndIndex >= 0; longEndIndex--) {
            int longIndexValue = longArr[longEndIndex];

            for (; shortEffectiveEndIndex >= 0; shortEffectiveEndIndex--) {
                int shortIndexValue = shortArr[shortEffectiveEndIndex];
                if (shortIndexValue < longIndexValue) {
                    break;
                }
                longArr[totalEndIndex] = shortIndexValue;
                totalEndIndex--;
            }
            longArr[totalEndIndex--] = longIndexValue;
        }

        if (shortEffectiveEndIndex >= 0) {
            for (int effectiveEndIndex = shortEffectiveEndIndex; effectiveEndIndex >= 0; effectiveEndIndex--) {
                longArr[totalEndIndex] = shortArr[effectiveEndIndex];
                totalEndIndex--;
            }
        }

    }
}
