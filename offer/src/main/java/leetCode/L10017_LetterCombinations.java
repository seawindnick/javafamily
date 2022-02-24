package leetCode;

import com.alibaba.fastjson.JSONArray;

import java.util.*;

////给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
////
//// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
////
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：digits = "23"
////输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//// 
////
//// 示例 2： 
////
//// 
////输入：digits = ""
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：digits = "2"
////输出：["a","b","c"]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= digits.length <= 4 
//// digits[i] 是范围 ['2', '9'] 的一个数字。 
//// 
//// Related Topics 哈希表 字符串 回溯 
//// 👍 1438 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
public class L10017_LetterCombinations {
    public static void main(String[] args) {
        List<String> list = letterCombinations("2");
        System.out.println(JSONArray.toJSONString(list));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }


        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));


        char[] array = digits.toCharArray();
        for (char c : array) {
            if (!('2' <= c && c <= '9')) {
                return new ArrayList<>();
            }
        }

        List<String> result = new ArrayList<>();
        List<String> singleStr = new ArrayList<>();

        letterCombinations(0, singleStr, result, array, map);

        return result;

    }

    private static void letterCombinations(int startIndex, List<String> singleStr, List<String> result, char[] array, Map<Character, List<String>> map) {
        if (startIndex > array.length) {
            return;
        }

        List<String> list = map.get(array[startIndex]);
        if (startIndex == array.length - 1) {
            for (String str : list) {
                singleStr.add(str);
                String value = String.join("", singleStr);
                result.add(value);
                singleStr.remove(singleStr.size() - 1);
            }
            return;
        }

        for (String str : list) {
            singleStr.add(str);
            letterCombinations(startIndex + 1, singleStr, result, array, map);
            singleStr.remove(singleStr.size() - 1);
        }

    }
}

