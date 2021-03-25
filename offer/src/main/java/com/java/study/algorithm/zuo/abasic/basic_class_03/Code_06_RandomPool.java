package com.java.study.algorithm.zuo.abasic.basic_class_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 设计RandomPool结构
 * 【题目】
 * 设计一种结构，在该结构中有如下三个功能:
 * insert(key):将某个key加入到该结构，做到不重复加入。
 * delete(key):将原本在结构中的某个key移除。
 * getRandom():等概率随机返回结构中的任何一个key。
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)。
 */
public class Code_06_RandomPool {

    public static class MyRandomPool<T> {
        private Map<T/*key*/, Integer/*位置*/> keyMap = new HashMap<>();
        private Map<Integer/*位置*/, T/*key*/> indexMap = new HashMap<>();
        /**
         * 也代表着下一次元素插入的位置
         */
        private int size = 0;


        /**
         * 1.存在于集合中，直接返回
         * 2. 不存在于集合中，进行添加
         *
         * @param value
         */
        public void insert(T value) {
            if (keyMap.containsKey(value)) {
                return;
            }

            keyMap.put(value, size);
            indexMap.put(size++, value);
        }


        /**
         * 1.不存在于集合中，直接进行忽略
         * 2.存在于集合中，且是最后一位 直接进行删除,size--
         * 3.存在于集合中间位置，将其与最后一位元素位置进行置换，删除最后一位元素，size--
         *
         * @param value
         */
        public void delete(T value) {
            if (!keyMap.containsKey(value)) {
                return;
            }


//            int index = keyMap.get(value);
//            if (index == size - 1) {
//                this.deleteLastest();
//                return;
//            }
//
//            int lastIndex = size - 1;
//            T lastValue = indexMap.get(lastIndex);
//            keyMap.put(lastValue, index);
//            indexMap.put(index, lastValue);
//
//            keyMap.put(value, lastIndex);
//            indexMap.put(lastIndex, value);
//
//
//            this.deleteLastest();


            int index = keyMap.get(value);
            T lastValue = indexMap.get(--size);

            //index位置的存储元素替换成最后一个节点的元素
            //最后一个节点元素的位置替换成当前位置
            indexMap.put(index, lastValue);
            keyMap.put(lastValue, index);

            //将最后一个元素位置信息从indexMap中删除
            //将当前要删除的元素进行删除操作
            indexMap.remove(size);
            keyMap.remove(value);

        }

        private void deleteLastest() {
            if (keyMap.isEmpty()) {
                throw new IllegalArgumentException("集合是空的");
            }

            Object value = indexMap.get(--size);
            indexMap.remove(size);
            keyMap.remove(value);
        }


        public T getRandom() {
            int randomIndex = (int) (Math.random() * this.size);
            return indexMap.get(randomIndex);
        }
    }


    public static void main(String[] args) {
        MyRandomPool<String> pool = new MyRandomPool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");

        pool.delete("zuo");

        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }


}