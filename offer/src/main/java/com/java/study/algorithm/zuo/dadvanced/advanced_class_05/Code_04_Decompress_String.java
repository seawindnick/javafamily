package com.java.study.algorithm.zuo.dadvanced.advanced_class_05;

import lombok.Data;

/**
 * 某位程序想出了一个压缩字符串的方法，压缩
 * 后的字符串如下:
 * 3{a}2{bc}，3{a2{c}}，2{abc}3{cd}ef，
 * 现在 需要你写一个解 压的程序，还原原始的字符串。
 * 如: s = "3{d}2{bc}", return "dddbcbc".
 * s = "3{a2{d}}", return "addaddadd".
 * s = "2{efg}3{cd}ef", return "efgefgcdcdcdef". 重复次数可以 确保是一个正整数。
 */
public class Code_04_Decompress_String {


    public static String Decompress_String(String str) {

        ParseResult parseResult = decompressString2(str, 0);
        return parseResult.str;
    }

    private static ParseResult decompressString2(String str, int index) {
        if (index >= str.length()) {
            return new ParseResult("", str.length());
        }


        String indexStr = "";
        int times = 0;

        while (index < str.length() && str.charAt(index) != '}') {
            char indexChar = str.charAt(index);
            if (indexChar == '{') {
                ParseResult parseResult = decompressString(str, index + 1);
                while (times > 0) {
                    indexStr = indexStr + parseResult.str;
                    times--;
                }
                index = parseResult.nextIndex + 1;
            } else {
                if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                    times = times * 10 + (str.charAt(index) - '0');
                } else {
                    indexStr = indexStr + str.charAt(index);
                }
                index++;
            }

        }

        return new ParseResult(indexStr, index);
    }

    private static ParseResult decompressString(String str, int index) {
        if (index >= str.length()) {
            return new ParseResult("", str.length());
        }


        String indexStr = "";
        int times = 0;

        while (index < str.length()) {
            char indexChar = str.charAt(index);
            if (indexChar == '}') {
                return new ParseResult(indexStr, index);
            }

            if (indexChar == '{') {
                ParseResult parseResult = decompressString(str, index + 1);
                while (times > 0) {
                    indexStr = indexStr + parseResult.str;
                    times--;
                }
                index = parseResult.nextIndex;
                break;
            }

            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                times = times * 10 + (str.charAt(index) - '0');
            } else {
                indexStr = indexStr + str.charAt(index);
            }
            index++;
        }


        String result = indexStr + decompressString(str, index + 1).str;
        return new ParseResult(result, str.length());
    }


    @Data
    public static class ParseResult {
        private String str;
        private int nextIndex;

        public ParseResult(String str, int nextIndex) {
            this.str = str;
            this.nextIndex = nextIndex;
        }
    }

    public static void main(String[] args) {
        System.out.println(Decompress_String("3{a2{d}}"));
        System.out.println("----------");
    }

}