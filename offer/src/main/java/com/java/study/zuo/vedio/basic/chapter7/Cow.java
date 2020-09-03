package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 23:44
 */
public class Cow {


    public static long getCow(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        return getCow(n - 1) + getCow(n - 3);
    }


    public static long getCow1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        long[] arr = new long[n];


        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }
        return arr[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(getCow(55));
        System.out.println(getCow1(55));
    }
}
