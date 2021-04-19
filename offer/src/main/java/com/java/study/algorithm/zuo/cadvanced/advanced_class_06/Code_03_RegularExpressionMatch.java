package com.java.study.algorithm.zuo.cadvanced.advanced_class_06;

/**
 * 字符串匹配问题
 * 【题目】 给定字符串str，其中绝对不含有字符'.'和'*'。再给定字符串exp， 其中可以含有'.'或'*'，'*'字符不能是exp的首字符，并且任意两个 '*'字符不相邻。exp中的'.'代表任何一个字符，exp中的'*'表示'*' 的前一个字符可以有0个或者多个。请写一个函数，判断str是否能被 exp匹配。
 * 【举例】
 * str="abc"，exp="abc"，返回true。 str="abc"，exp="a.c"，exp中单个'.'可以代表任意字符，所以返回 true。 str="abcd"，exp=".*"。exp中'*'的前一个字符是'.'，所以可表示任 意数量的'.'字符，当exp是"...."时与"abcd"匹配，返回true。 str=""，exp="..*"。exp中'*'的前一个字符是'.'，可表示任意数量 的'.'字符，但是".*"之前还有一个'.'字符，该字符不受'*'的影响， 所以str起码有一个字符才能被exp匹配。所以返回false。
 */
public class Code_03_RegularExpressionMatch{
}