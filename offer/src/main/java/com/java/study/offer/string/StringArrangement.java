package com.java.study.offer.string;

import java.util.ArrayList;
import java.util.List;

public class StringArrangement {

    public static void main(String[] args) {
        String str = "abcertgh";
        List<String> list = new ArrayList<>();
        permutation(str.toCharArray(), 0, list);

        list.forEach(s ->
                System.out.println(s));

    }




    static void permutation(char[] strArray, int index, List<String> list) {
        if (index == strArray.length - 1) {
            if (!list.contains(String.valueOf(strArray)))
                list.add(String.valueOf(strArray));
        } else {
            for (int i = index; i < strArray.length; i++) {
                //开始元素与其后元素进行交换
                char temp = strArray[index];
                strArray[index] = strArray[i];
                strArray[i] = temp;
                permutation(strArray, index + 1, list);

                //将数据还原，执行下一次循环
                strArray[i] = strArray[index];
                strArray[index] = temp;
            }
        }

    }
}
