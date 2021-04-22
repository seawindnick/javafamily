package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

import com.alibaba.fastjson.JSONArray;

/**
 * 规定1是丑数，其他的数如果只含有2或3或5的因子，那么这个 数也是丑数。 比如依次的丑数为:1,2,3,5,6,8,9,10,12,15... 求第n个丑数
 */
public class Code_01_Ugly_Number {


    public static long Ugly_Number(int n) {
        long[] result = new long[n];
        result[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            long value = Math.min(result[index2] * 2, Math.min(result[index3] * 3, result[index5] * 5));
            if (value >= result[index2] * 2) {
                index2++;
            }
            if (value >= result[index3] * 3) {
                index3++;
            }
            if (value >= result[index5] * 5) {
                index5++;
            }
            result[i] = value;
        }

        System.out.println(JSONArray.toJSONString(result));
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(Ugly_Number(20));
    }
}