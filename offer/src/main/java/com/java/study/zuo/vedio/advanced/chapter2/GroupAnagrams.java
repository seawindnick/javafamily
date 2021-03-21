package com.java.study.zuo.vedio.advanced.chapter2;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 16:30
 */
public class GroupAnagrams {
    public static Collection<List<String>> groupAnagrams(String[] list) {
        if (list == null || list.length == 0) {
            return new ArrayList<>();
        }


        Map<String, List<String>> map = groupAnagramsMap(list);
        return map.values();
    }

    private static Map<String, List<String>> groupAnagramsMap(String[] list) {
        Map<String, List<String>> targetMap = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            String str = list[i];
            String key = buildKey(str);

            List<String> targetList = targetMap.get(key);
            if (targetList == null){
                targetList = new ArrayList<>();
                targetMap.put(key,targetList);
            }
            targetList.add(str);
        }
        return targetMap;
    }

    private static String buildKey(String str) {
        int[] arr = new int[26];
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char indexChar = array[i];
            arr[indexChar - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]).append("_");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSONArray.toJSONString(groupAnagrams(arr)));
    }


}
