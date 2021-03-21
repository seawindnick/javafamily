package com.java.study.zuo.vedio.advanced.chapter5;

import lombok.Data;

/**
 * <Description>
 * 某位程序想出了一个压缩字符串的方法，压缩后的字符串如下:
 * 3{a}2{bc}，3{a2{c}}，2{abc}3{cd}ef，
 * 现在 需要你写一个解 压的程序，还原原始的字符串。
 * 如: s = "3{d}2{bc}", return "dddbcbc". s = "3{a2{d}}",
 * return "addaddadd". s = "2{efg}3{cd}ef", return "efgefgcdcdcdef".
 * 重复次数可以 确保是一个正整数。
 *
 * @author hushiye
 * @since 2020-09-15 11:38
 */
public class DecompressString {

    @Data
    private static class Result {
        private String str;
        private int nextIndex;

        public Result(String str, int nextIndex) {
            this.str = str;
            this.nextIndex = nextIndex;
        }
    }


    public static String decompressString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        char[] array = str.toCharArray();


        Result result = decompressString(array, 0);
        return result.str;
    }

    private static Result decompressString(char[] array, int beginIndex) {
        if (beginIndex == array.length) {
            return new Result("", array.length);
        }

        int times = 0;
        String result = "";
        while (beginIndex < array.length) {
            char charIndex = array[beginIndex];
            if ('0' <= charIndex && charIndex <= '9') {
                times = times * 10 + (charIndex - '0');
                beginIndex++;
                continue;
            }
            if (charIndex == '{') {
                Result nextResult = decompressString(array, beginIndex + 1);
                String str = buildStr(nextResult.str, times);
                result = result + str;
                beginIndex = nextResult.nextIndex;
                times = 0;
                continue;
            }

            if (charIndex == '}') {
                return new Result(result, beginIndex + 1);
            }

            result += charIndex;
            beginIndex++;
        }

        return new Result(result, beginIndex);

    }

    private static String buildStr(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;

    }

    public static void main(String[] args) {
        String str = "2{efg}3{cd}ef";
        System.out.println(decompressString(str));
    }


}
