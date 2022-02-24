package leetCode;//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 727 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10049_GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(JSONArray.toJSONString(groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"})));
    }

    public static List<List<String>> groupAnagrams(String[] arr) {

        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] result = new int[26];
        for (String str : arr) {
            String key = calculate(str,result);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String calculate(String str,int[] result) {

        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (char c : str.toCharArray()) {
            result[c - 'a']++;
        }

        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                builder.append(i + 'a').append(result[i]).append(",");
            }
        }

        return builder.toString();
    }


}

