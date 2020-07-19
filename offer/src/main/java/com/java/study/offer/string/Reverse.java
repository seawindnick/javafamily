package com.java.study.offer.string;

import com.alibaba.fastjson.JSONArray;

public class Reverse {
    public static void main(String[] args) {
        String str = "Im am a students. ";

        reverse(str);
    }

    private static void reverse(String str) {
        char[] arrays = str.toCharArray();
        //翻转所有字符
        reverseChar(arrays, 0, arrays.length - 1);

        //翻转每个单词中顺序
        reverseSentence(arrays);
        System.out.println(JSONArray.toJSONString(arrays));
    }

    private static void reverseSentence(char[] arrays) {

        int startIndex = 0;
        int endIndex = arrays.length - 1;

        //单个单词最后结尾位置
        int singleEndIndex = startIndex;
        while (startIndex < endIndex) {

            if (arrays[singleEndIndex] != ' ') {
                //最后一个元素
                if(singleEndIndex == endIndex){
                    reverseChar(arrays, startIndex, singleEndIndex );
                    break;
                }
                singleEndIndex++;
                continue;
            }
            reverseChar(arrays, startIndex, singleEndIndex - 1);
            startIndex = singleEndIndex + 1;
            singleEndIndex = startIndex;
        }

    }

    //逆转所有元素信息
    private static void reverseChar(char[] arrays, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = arrays[startIndex];
            arrays[startIndex] = arrays[endIndex];
            arrays[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

    }

}
