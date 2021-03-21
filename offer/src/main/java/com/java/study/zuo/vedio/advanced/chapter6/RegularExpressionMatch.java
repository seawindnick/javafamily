package com.java.study.zuo.vedio.advanced.chapter6;

/**
 * <Description>
 * <p>
 * 字符串匹配问题
 * 【题目】
 * 给定字符串str，其中绝对不含有字符'.'和'*'。
 * 再给定字符串exp，其中可以含有'.'或'*'，'*' 字符不能是exp的首字符，
 * 并且任意两个'*'字符不相邻。exp中的'.'代表任何一个字符，
 * exp中的'*'表示'*'的前一个字符可以有0个或者多个。请写一个函数，判断str是否能被exp 匹配。
 * 【举例】
 * str="abc"，exp="abc"，返回true。
 * str="abc"，exp="a.c"，exp中单个'.'可以代表任意字符，所以返回true。
 * str="abcd"，exp=".*"。exp中'*'的前一个字符是'.'，所以可表示任意数量的'.'字符，
 * 当 exp是"...."时与"abcd"匹配，返回true。
 * str=""，exp="..*"。exp中'*'的前一个字符是'.'，可表示任意数量的'.'字符，但是".*"之前还 有一个'.'字符，该字符不受'*'的影响，所以str起码有一个字符才能被exp匹配。所以返回 false。
 *
 * @author hushiye
 * @since 2020-09-17 18:43
 */
public class RegularExpressionMatch {


    public static Boolean regularExpressionMatch(String str, String express) {
        if (str == null) {
            return false;
        }

        return validate(express) && regularExpressionMatch(str, express, 0, 0);


    }

    /**
     * express 信息不能以*开头
     * express 信息不能两个 * 连着
     *
     * @param str
     * @param express
     * @param strIndex
     * @param expressIndex
     * @return
     */
    private static boolean regularExpressionMatch(String str, String express, int strIndex, int expressIndex) {
        // 如果 expressIndex 到达最后位置，如果想要匹配，那么要匹配的数据也需要到达最后的位置
        if (expressIndex == express.length()) {
            return strIndex == str.length();
        }

        // (expressIndex == express.length() - 1  表示表达式没有下一位信息了
        if (expressIndex == express.length() - 1 || express.charAt(expressIndex + 1) != '*') {
            return strIndex != str.length() && (str.charAt(strIndex) == express.charAt(expressIndex) || express.charAt(expressIndex) == '.')
                    && regularExpressionMatch(str, express, strIndex + 1, expressIndex + 1);

        }

        // 整体 * 字符是跳过，不进行处理的
        // 如果匹配字符是 . 或者与当前字符是匹配的
        while (strIndex != str.length() && (str.charAt(strIndex) == express.charAt(expressIndex) || express.charAt(expressIndex) == '.')) {
            //尝试当前字符和  * 后面一个字符进行匹配
            if (regularExpressionMatch(str, express, strIndex, expressIndex + 2)) {
                return Boolean.TRUE;
            }
            //如果上述匹配失败，将 str 当前作为 x* 匹配信息，继续下一个位置的匹配
            strIndex++;
        }
        return (regularExpressionMatch(str, express, strIndex, expressIndex + 2));
    }

    private static Boolean validate(String express) {

        for (int i = 0; i < express.length(); i++) {
            if ('*' == express.charAt(i) && (i == 0 || '*' == express.charAt(i - 1))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }


    public static boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return process(s, e, 0, 0);
    }

    public static boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length) {
            return si == s.length;
        }
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (e[ei] == s[si] || e[ei] == '.')
                    && process(s, e, si + 1, ei + 1);
        }
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }


    public static void main(String[] args) {
        String str = "aaab";
        String exp = "a*bc";
        System.out.println(regularExpressionMatch(str, exp));
//        System.out.println(isMatchDP(str, exp));

    }


}
