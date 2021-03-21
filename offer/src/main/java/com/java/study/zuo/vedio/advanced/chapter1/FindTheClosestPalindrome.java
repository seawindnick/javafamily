package com.java.study.zuo.vedio.advanced.chapter1;


/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-03 22:50
 */
public class FindTheClosestPalindrome {

    public static Long findTheClosestPalindrome(long value) {
        if (value < 0) {
            return null;
        }

        if (value == 0) {
            return 1L;
        }

        String valueStr = String.valueOf(value);
        char[] arr = new char[valueStr.length()];
        for (int i = 0; i < valueStr.length(); i++) {
            arr[i] = valueStr.charAt(i);
        }
        int leftIndex = 0;
        int endIndex = arr.length - 1;
        while (leftIndex < endIndex) {
            arr[endIndex--] = arr[leftIndex++];
        }

        Long palindromeValue = Long.parseLong(String.valueOf(arr));
        //找小于的值
        if (palindromeValue > value) {
            long minValue = findMinValue(valueStr);
            return (palindromeValue - value) >= (value - minValue) ? minValue : palindromeValue;

        } else if (palindromeValue < value) {//找大于的值
            long maxValue = findMaxValue(valueStr);
            return (maxValue - value) >= (value - palindromeValue) ? palindromeValue : maxValue;

        } else {//最小值和最大值都找
            long minValue = findMinValue(valueStr);
            long maxValue = findMaxValue(valueStr);

            return maxValue - value >= (value - minValue) ? minValue : maxValue;
        }

    }

    private static long findMaxValue(String valueStr) {
        int[] array = new int[valueStr.length() + 1];
        int startIndex = 0;
        array[startIndex++] = 0;

        for (int i = 0; i < valueStr.length(); i++) {
            array[startIndex++] = valueStr.charAt(i) - '0';
        }

        int midIndex = (valueStr.length() - 1) / 2 + 1;
        array[midIndex]++;
        for (int index = midIndex; index >= 0; index--) {
            int indexValue = array[index];
            if (indexValue == 10) {
                array[index] = 0;
                array[index - 1]++;
            } else {
                break;
            }
        }

        startIndex = array[0] == 1 ? 0 : 1;
        int endIndex = array.length - 1;
        while (startIndex < endIndex) {
            array[endIndex--] = array[startIndex++];
        }

        long value = calculate(array);

        return value;

    }

    private static long calculate(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum * 10 + array[i];
        }
        return sum;
    }

    private static long findMinValue(String valueStr) {

        int[] target = new int[valueStr.length()];

        char[] array = valueStr.toCharArray();
        for (int i = 0; i < array.length; i++) {
            target[i] = array[i] - '0';
        }


        int mid = (valueStr.length() - 1) / 2;
        target[mid]--;
        for (int i = mid; i >= 0; i--) {
            int indexValue = target[i];
            if (indexValue < 0) {
                target[i] = 9;
                target[i - 1]--;
            } else {
                break;
            }
        }

        if (target[0] == 0) {
            if (valueStr.length() == 1) {
                return 0;
            }

            for (int i = 1; i < target.length; i++) {
                target[i] = 9;
            }
        } else {
            int leftIndex = 0;
            int endIndex = target.length - 1;
            while (leftIndex < endIndex) {
                target[endIndex--] = target[leftIndex++];
            }
        }
        return calculate(target);
    }


    public static String nearestPalindromic(long value) {
        String n = String.valueOf(value);
        Long num = Long.valueOf(n);
        Long raw = getRawPalindrome(n);
        Long big = raw > num ? raw : getBigPalindrome(raw);
        Long small = raw < num ? raw : getSmallPalindrome(raw);
        return String.valueOf(big - num >= num - small ? small : big);
    }

    public static Long getRawPalindrome(String n) {
        char[] chs = n.toCharArray();
        int len = chs.length;
        for (int i = 0; i < len / 2; i++) {
            chs[len - 1 - i] = chs[i];
        }
        return Long.valueOf(String.valueOf(chs));
    }

    public static Long getBigPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length + 1];
        res[0] = '0';
        for (int i = 0; i < chs.length; i++) {
            res[i + 1] = chs[i];
        }
        int size = chs.length;
        for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
            if (++res[j] > '9') {
                res[j] = '0';
            } else {
                break;
            }
        }
        int offset = res[0] == '1' ? 1 : 0;
        size = res.length;
        for (int i = size - 1; i >= (size + offset) / 2; i--) {
            res[i] = res[size - i - offset];
        }
        return Long.valueOf(String.valueOf(res));
    }

    public static Long getSmallPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length];
        int size = res.length;
        for (int i = 0; i < size; i++) {
            res[i] = chs[i];
        }
        for (int j = (size - 1) / 2; j >= 0; j--) {
            if (--res[j] < '0') {
                res[j] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = '9';
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        for (int k = 0; k < size / 2; k++) {
            res[size - 1 - k] = res[k];
        }
        return Long.valueOf(String.valueOf(res));
    }

    public static void main(String[] args) {

        long value = 11111;

        System.out.println(findTheClosestPalindrome(value));
        System.out.println(nearestPalindromic(value));

//        for (int i = 0; i < 1000000; i++) {
//            long value = (long) (Math.random() * 10000000L + 1);
//            System.out.println(value);
//            String value1 = String.valueOf(findTheClosestPalindrome(value));
//            String value2 = nearestPalindromic(value);
//
//            if (!Objects.equals(value1, value2)) {
//                System.out.println("fuck!");
//                break;
//            }
//////            System.out.println("ok");
//        }


    }

}
