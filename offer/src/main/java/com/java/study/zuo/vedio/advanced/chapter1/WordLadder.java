package com.java.study.zuo.vedio.advanced.chapter1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-03 19:36
 */
public class WordLadder {

    public static List<List<String>> wordLadder(String begin, String target, List<String> words) {
        if (words == null || words.isEmpty()) {
            return Collections.emptyList();
        }

        Set<String> wordsSet = new HashSet<>(words);
        Map<String, List<String>> keyWordAndNextWordsMap = buildKeyWordAndNextWordsMap(begin, wordsSet);
        Map<String, Integer> transStepMap = getDistances(begin, keyWordAndNextWordsMap);

        List<List<String>> list = new ArrayList<>();
        List<String> path = new ArrayList<>();

        searchPath(list, path, begin, transStepMap, keyWordAndNextWordsMap, target);

        return list;


    }

    private static void searchPath(List<List<String>> list, List<String> path, String node, Map<String, Integer> transStepMap, Map<String, List<String>> keyWordAndNextWordsMap, String target) {
        path.add(node);
        if (Objects.equals(node, target)) {
            list.add(new ArrayList<>(path));
        } else {
            List<String> next = keyWordAndNextWordsMap.get(node);
            for (String s : next) {
                if (transStepMap.get(s) == transStepMap.get(node) + 1) {
                    searchPath(list, path, s, transStepMap, keyWordAndNextWordsMap, target);
                }
            }
        }
        path.remove(node);
    }

    private static Map<String, Integer> getDistances(String begin, Map<String, List<String>> keyWordAndNextWordsMap) {
        Map<String, Integer> map = new HashMap<>();
        map.put(begin, 0);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int level = map.get(cur);
            List<String> list = keyWordAndNextWordsMap.get(cur);
            for (String s : list) {
                if (!map.containsKey(s)) {
                    map.put(s, level + 1);
                    queue.add(s);

                }
            }
        }
        return map;


//        Map<String, Integer> map = new HashMap<>();
//        Queue<String> queue = new ArrayDeque<>();
//        queue.add(begin);
//
//        while (!queue.isEmpty()) {
//            String str = queue.poll();
//            int level = 0;
//            if (map.containsKey(str)) {
//                level = map.get(str);
//            } else {
//                level = 0;
//                map.put(str, level);
//            }
//            List<String> nextList = keyWordAndNextWordsMap.get(str);
//            if (nextList != null){
//                for (String s : nextList) {
//                    if (!map.containsKey(s)) {
//                        queue.add(s);
//                        map.put(s, level + 1);
//                    }
//                }
//            }
//        }
//
//        return map;
    }

    private static Map<String, List<String>> buildKeyWordAndNextWordsMap(String begin, Set<String> wordsSet) {
        Map<String, List<String>> map = new HashMap<>();

        List<String> list = findNextList(begin, wordsSet);
        map.put(begin, list);

        for (String str : wordsSet) {
            List<String> temp = findNextList(str, wordsSet);
            map.put(str, temp);

        }
        return map;
    }

    private static List<String> findNextList(String str, Set<String> wordsSet) {
        List<String> list = new ArrayList<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char indexChar = array[i];
            for (char replace = 'a'; replace <= 'z'; replace++) {
                if (indexChar == replace) {
                    continue;
                }
                array[i] = replace;
                String newValue = String.valueOf(array);
                if (wordsSet.contains(newValue)) {
                    list.add(newValue);
                }
                array[i] = indexChar;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> list = wordLadder(beginWord, endWord, wordList);

        System.out.println(JSONArray.toJSONString(list));

    }
}
