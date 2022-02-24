package leetCode;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯
// 👍 1948 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10022_GenerateParenthesis {

    public static void main(String[] args) {
        List<String> list = generateParenthesis3(3);
        System.out.println(JSONArray.toJSONString(list));
    }

    private static List<String> generateParenthesis3(int n) {


        List<List<String>> dp = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add("");
        dp.add(first);

        List<String> second = new ArrayList<>();
        second.add("()");
        dp.add(second);


        //为每个DP点设置值
        for (int i = 2; i <= n; i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> leftHalfDp = dp.get(j);
                List<String> rightHalfDp = dp.get(i - j - 1);

                for (String left : leftHalfDp) {
                    for (String right : rightHalfDp) {
                        String value = "(" + left + ")" + right;
                        tempList.add(value);
                    }
                }
            }

            dp.add(tempList);
        }

        return dp.get(n);


    }

//    private static List<String> generateParenthesis2(int n) {
//        if (n <= 0) {
//            return new ArrayList<>();
//        }
//
//
//        List<String> answmer = new ArrayList<>();
//        StringBuilder builder = new StringBuilder();
//        int leftCount = 0;
//        int rightCount = 0;
//        int curIndex = 0;
//        generateParenthesis(answmer, leftCount, rightCount, n, builder, curIndex);
//
//        return answmer;
//
//    }
//
//    private static void generateParenthesis(List<String> answmer, int leftCount, int rightCount, int n, StringBuilder builder, int curIndex) {
//        if (builder.length() == 2 * n) {
//            answmer.add(builder.toString());
//            return;
//        }
//
//
//        if (leftCount < n) {
//            builder.append("(");
//            generateParenthesis(answmer, leftCount + 1, rightCount, n, builder, curIndex + 1);
//            builder.deleteCharAt(curIndex);
//        }
//
//        if (leftCount > rightCount) {
//            builder.append(")");
//            generateParenthesis(answmer, leftCount, rightCount + 1, n, builder, curIndex + 1);
//            builder.deleteCharAt(curIndex);
//        }
//
//
//    }


//    public static List<String> generateParenthesis(int n) {
//        if (n <= 0) {
//            return new ArrayList<>();
//        }
//
//        String[] signArray = new String[]{"(", ")"};
//
//        Set<String> targetSet = new HashSet<>();
//        int startIndex = 0;
//        String[] array = new String[2 * n];
//        generateParenthesis(startIndex, targetSet, array, signArray);
//        List<String> result = new ArrayList<>();
//        result.addAll(targetSet);
//        return result;
//    }
//
//    private static void generateParenthesis(int startIndex, Set<String> targetSet, String[] array, String[] signArray) {
//        if (startIndex >= array.length) {
//            return;
//        }
//
//        for (int i = 0; i < signArray.length; i++) {
//            array[startIndex] = signArray[i];
//            if (startIndex == array.length - 1) {
//                String value = String.join("", array);
//                if (isValid(value)){
//                    targetSet.add(value);
//                }
//
//            } else {
//                generateParenthesis(startIndex + 1, targetSet, array, signArray);
//            }
//            array[startIndex] = null;
//        }
//
//    }
//
//    private static boolean isValid(String value) {
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < value.toCharArray().length; i++) {
//            String indexCharValue = String.valueOf(value.charAt(i));
//            if (indexCharValue.equals("(")){
//                stack.push(indexCharValue);
//            }else {
//                if (stack.isEmpty() || !stack.pop().equals("(")){
//                    return false;
//                }
//
//            }
//
//        }
//        return stack.isEmpty();
//    }
}


