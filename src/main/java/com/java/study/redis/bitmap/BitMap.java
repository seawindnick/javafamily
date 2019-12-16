package com.java.study.redis.bitmap;

import com.alibaba.fastjson.JSONArray;

public class BitMap {
    public static void main(String[] args) {
        String str = "h";
        String str1 = "e";
        byte[] bytes = str.getBytes();
        byte[] bytes1 = str1.getBytes();
        System.out.println(JSONArray.toJSONString(str.getBytes()));
        System.out.println(JSONArray.toJSONString(str1.getBytes()));
    }
}
