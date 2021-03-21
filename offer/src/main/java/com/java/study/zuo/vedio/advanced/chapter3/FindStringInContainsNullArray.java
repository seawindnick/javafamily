package com.java.study.zuo.vedio.advanced.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-09 10:54
 */
public class FindStringInContainsNullArray {

    public static int getIndex(String[] arr, String target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }


        int res = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] != null) {
                if (target.equals(arr[mid])) {
                    res = mid;
                    right = mid - 1;
                } else {
                    if (target.compareTo(arr[mid]) < 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                int index = mid - 1;
                for (; index >= left; index--) {
                    if (arr[index] != null) {
                        break;
                    }
                }


                if (index < left || target.compareTo(arr[index]) > 0) {
                    left = mid + 1;
                } else if (target.compareTo(arr[index]) < 0) {
                    right = index - 1;
                } else {
                    res = index;
                    right = index - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{null, "a", null, "a", null, "b", null,
                null, null, "b", null, "c", null, "c", null, null, "d", null,
                null, null, null, null, "d", null, "e", null, null, "e", null,
                null, null, "f", null, "f", null};
//        String str1 = "a";
//        System.out.println(getIndex(strs, str1));
//        String str2 = "b";
//        System.out.println(getIndex(strs, str2));
//        String str3 = "c";
//        System.out.println(getIndex(strs, str3));
        String str4 = "d";
        System.out.println(getIndex(strs, str4));
        String str5 = "e";
        System.out.println(getIndex(strs, str5));
        String str6 = "f";
        System.out.println(getIndex(strs, str6));

    }

}
