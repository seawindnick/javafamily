package com.java.study.algorithm.zuo.dadvanced.advanced_class_07;

/**
 * 给定一个长度大于1的字符串，我们可以把这个字符串分成两个非空的部分， 并且每个部分还能细分下去，
 * 并且可以用二叉树的形式来表达，比如
 * 字符串 s1 = "great": 可以分解成这么一个样子(这只是其中一种分解结构)
 * great /\
 * gr eat /\/\
 * g r e at /\
 * at 我们说s1的搅乱串，指的是在任意一种分解结构中，随意交换某个节点的左
 * 右两个孩子所形成的字符串。
 * 比如我们可以选择在上面的分解结构中，交换“gr”这个节点的孩子节点，形 成的树为:
 * rgeat /\
 * rg eat /\/\
 * r g e at /\
 * at 那么“rgeat”，是“great”的搅乱串。
 *同样，我们可以继续交换“eat”节点的左右孩子，形成:
 * rgtae /\
 * rg tae /\/\
 * r g ta e /\
 * t a 那么“rgtae”，是“great”的搅乱串。
 * 所以一个字符串的搅乱串是非常之多的，分解结构本身就有很多种， 而且每一种分解结构都可以随意交换任意一个节点的左右孩子。
 * 给定两个字符串s1和s2，判断s2是不是s1的搅乱串。
 *
 */
public class Code_01_Scramble_String{
}