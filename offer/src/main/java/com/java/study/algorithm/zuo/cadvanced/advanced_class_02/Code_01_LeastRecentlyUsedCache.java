package com.java.study.algorithm.zuo.cadvanced.advanced_class_02;

/**
 * 设计可以变更的缓存结构
 * 【题目】 设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并有两个功能:
 * set(key,value):将记录(key,value)插入该结构。
 * get(key):返回key对应的value值。 【要求】
 * 1.set和get方法的时间复杂度为O(1)。 2.某个key的set或get操作一旦发生，认为这个key的记录成了最经常使用的。 3.当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。 【举例】
 * 假设缓存结构的实例是cache，大小为3，并依次发生如下行为: 1.cache.set("A",1)。最经常使用的记录为("A",1)。 2.cache.set("B",2)。最经常使用的记录为("B",2)，("A",1)变为最不经常的。 3.cache.set("C",3)。最经常使用的记录为("C",2)，("A",1)还是最不经常的。 4.cache.get("A")。最经常使用的记录为("A",1)，("B",2)变为最不经常的。 5.cache.set("D",4)。大小超过了3，所以移除此时最不经常使用的记录("B",2)，加入记录 ("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的记录。
 */
public class Code_01_LeastRecentlyUsedCache {
}