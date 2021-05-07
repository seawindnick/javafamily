package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * 如果str1和str2包含的字符种类一样，并且每种字符的个数也 一样，那么str1和str2算作变形词。 给定一个字符类型的数组，请把变形词分组。比如
 * 输入:
 * [] 输出:
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ] 注意:所有的字符都是小写。
 */
public class Code_04_Group_Anagrams {

    public static List<List<String>> Group_Anagrams(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> targetMap = group(arr);
        List<List<String>> target = new ArrayList<>(targetMap.size());
        for (List<String> value : targetMap.values()) {
            target.add(value);
        }
        return target;
    }

    private static Map<String, List<String>> group(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        int[] countArray = new int[26];

        for (String str : arr) {
            String key = getKey(str, countArray);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);

        }

        return map;
    }

    private static String getKey(String str, int[] countArray) {
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            countArray[str.charAt(i) - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                stringBuilder.append(('a' + i)).append("_").append(countArray[i]).append("_");
            }
        }

        if (str.equals("rub") || str.equals("bur")) {
            System.out.println(stringBuilder.toString());
        }

        return stringBuilder.toString();
    }

//    private static String getKey(String str) {
//
//
//        TreeMap<Character, Integer> map = new TreeMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            Character character = str.charAt(i);
//            Integer count = map.getOrDefault(character, 0);
//            map.put(character, ++count);
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
//            Character key = characterIntegerEntry.getKey();
//            Integer count = characterIntegerEntry.getValue();
//            stringBuilder.append(key).append("_").append(count).append("_");
//        }
//
//        if (str.equals("rub") || str.equals("bur")) {
//            System.out.println(stringBuilder.toString());
//        }
//
//        return stringBuilder.toString();
//
//    }

    public static void main(String[] args) {
        String[] arr = new String[]{"chi", "nip", "lab", "mud", "fan", "yak", "kid", "lox", "joy", "rob", "cad", "hug", "ken", "oaf", "pus", "hos", "ton", "any", "sac", "mid", "nip", "ron", "tux", "set", "jug", "axe", "ago", "sob", "ode", "dot", "nit", "pug", "sue", "new", "rub", "sup", "ohs", "ski", "oaf", "don", "cob", "kin", "ark", "gay", "jay", "bur", "dot", "eat", "rca", "wad", "maj", "luz", "gad", "dam", "eon", "ark", "del", "sin", "tat"};
        System.out.println(JSONArray.toJSONString(Group_Anagrams(arr)));

    }


}