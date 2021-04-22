package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 给定两个单词beginWord和endWord，还有一本词典是list类型。
 * 找到所有从beginWord变到endWord的最短转换路径，变动的规则是:
 * 1，一次只能变一个位置的字符
 * 2，每一个转换后的word一定要在list中
 * 3，初始时list中没有beginWord这个词
 * 比如
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"] 返回:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 注意:
 * 1，返回值的类型为List<List<String>>
 * 2，如果不存在转化路径请返回空链表(不是null)
 * 3，所有的词一定都是相同长度的
 * 4，所有词都是小写的a~z
 * 5，在list中没有重复的词
 * 6，beginWord和endWord都不是空字符串或者null
 */
public class Code_06_Word_Ladder {


    private static List<List<String>> Word_Ladder2(String[] wordList, String beginWord, String endWord) {
        List<String> words = new ArrayList<>(Arrays.asList(wordList));
        words.add(beginWord);
        //获取下一步的信息
        Map<String, List<String>> nextMap = buildNextMap(words);
        Map<String, Integer> stepMap = buildStepMap(beginWord, nextMap);
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> target = new LinkedList<>();
        searchResult(beginWord, endWord, nextMap, stepMap, target, result);
        return result;
    }

    private static void getShortestPaths(String cur, String end, Map<String, List<String>> nexts, Map<String, Integer> distances, LinkedList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new LinkedList<String>(solution));
        } else {
            for (String next : nexts.get(cur)) {
                if (distances.get(next) == distances.get(cur) + 1) {
                    getShortestPaths(next, end, nexts, distances, solution, res);
                }
            }
        }
        solution.pollLast();
    }


    private static void searchResult(String curIndexStr, String endWord, Map<String, List<String>> nextMap, Map<String, Integer> stepMap, LinkedList<String> target, List<List<String>> result) {
        target.add(curIndexStr);
        if (curIndexStr.equals(endWord)) {
            result.add(new ArrayList<>(target));
        } else {
            for (String nextStr : nextMap.get(curIndexStr)) {
                if (stepMap.get(nextStr) == stepMap.get(curIndexStr) + 1) {
                    searchResult(nextStr, endWord, nextMap, stepMap, target, result);
                }

            }
        }

        target.removeLast();
    }

    private static Map<String, Integer> buildStepMap(String beginWord, Map<String, List<String>> nextMap) {
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 0);

        Set<String> exist = new HashSet<>();
        exist.add(beginWord);

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String indexStr = queue.poll();
            List<String> next = nextMap.get(indexStr);
            for (String nextStr : next) {
                if (!exist.contains(nextStr)) {
                    queue.add(nextStr);
                    map.put(nextStr, map.get(indexStr) + 1);
                    exist.add(indexStr);
                }
            }
        }
        return map;
    }


    private static Map<String, List<String>> buildNextMap(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            map.put(words.get(i), oneStepChange2(words.get(i), words));
        }
        return map;
    }


    public static List<String> oneStepChange2(String str, List<String> targetSet) {
        List<String> set = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char oldChar = arr[i];
            for (int j = 0; j < 26; j++) {
                char indexChar = (char) ('a' + (j - 0));
                if (indexChar == oldChar) {
                    continue;
                }

                arr[i] = indexChar;
                String value = String.valueOf(arr);
                if (targetSet.contains(value)) {
                    set.add(value);
                }
            }
            arr[i] = oldChar;
        }
        return set;
    }


    private static List<List<String>> Word_Ladder(String[] wordList, String beginWord, String endWord) {
        Map<String, Set<String>> nextMap = new HashMap<>();
        Set<String> targetSet = new HashSet<>(Arrays.asList(wordList));
        nextMap.put(beginWord, oneStepChange(beginWord, targetSet));
        for (int i = 0; i < wordList.length; i++) {
            nextMap.put(wordList[i], oneStepChange(wordList[i], targetSet));
        }

        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        findWordLadder(nextMap, beginWord, endWord, tempList, result);

        List<List<String>> value = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            minLength = Math.min(minLength, result.get(i).size());
        }

        for (int i = 0; i < result.size(); i++) {
            if (minLength == result.get(i).size()) {
                value.add(result.get(i));
            }
        }
        return value;
    }

    private static void findWordLadder(Map<String, Set<String>> nextMap, String beginWord, String endWord, List<String> result, List<List<String>> target) {
        Set<String> next = nextMap.get(beginWord);
        if (next == null) {
            return;
        }

        if (next.contains(endWord)) {
            result.add(endWord);
            target.add(new ArrayList<>(result));
            result.remove(endWord);
            return;
        }

        for (String str : next) {
            if (result.contains(str)) {
                continue;
            }

            result.add(str);
            findWordLadder(nextMap, str, endWord, result, target);
            result.remove(str);
        }
    }


    public static Set<String> oneStepChange(String str, Set<String> targetSet) {
        Set<String> set = new HashSet<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char oldChar = arr[i];
            for (int j = 0; j < 26; j++) {
                char indexChar = (char) ('a' + (j - 0));
                if (indexChar == oldChar) {
                    continue;
                }

                arr[i] = indexChar;
                String value = String.valueOf(arr);
                if (targetSet.contains(value)) {
                    set.add(value);
                }
            }
            arr[i] = oldChar;
        }
        return set;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(JSONArray.toJSONString(Word_Ladder2(wordList, beginWord, endWord)));
    }


}