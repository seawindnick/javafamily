package com.java.study.zuo.dynamicplanning;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 * 母牛每年生一只母牛，新出生的母牛三年后能每年生一只母牛，
 * 假设母牛不会死，求N年后，母牛的数量
 *
 * @author hushiye
 * @since 2020-08-09 23:07
 */
public class Cow {


    public static int calculateCow(int n) {
        if (n <= 3) {
            return n;
        }
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        int index = 3;
        while (index < n) {
            arr[index] = arr[index - 1] + arr[index - 3];
            index++;
        }

        return arr[n - 1];
    }


    public static int cowNumber1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static int cowNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }


    public static int calculateCowTenYearDie(int n) {
        if (n <= 3) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        int index = 3;
        while (index < n) {

            arr[index] = arr[index - 1] + arr[index - 3];
            index++;
        }

        if (n <= 5) {
            return arr[n - 1];
        } else {
            return arr[n - 1] - (arr[n - 5] * 2);
        }


    }

    public static void main(String[] args) {

        System.out.println(calculateCowTenYearDie(6));
    }
}
