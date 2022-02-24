package com.java.study.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/24/21 15:32
 */
public class ArrayListAndLinkedList {


    public static void main(String[] args) {
//        testHeadInsert();
//        System.out.println("-------------------");
//        testTailInsert();
//        System.out.println("-------------------");
        testMiddleInsert();
    }

    private static void testMiddleInsert() {
        testMiddleInsert((long) Math.pow(10, 5));
        testMiddleInsert((long) Math.pow(10, 6));
        testMiddleInsert((long) Math.pow(10, 7));
    }

    private static void testMiddleInsert(long longIndex) {

        Stack stack = new Stack();
        long time = System.currentTimeMillis();
        List<Long> list = new ArrayList<Long>();
        for (long i = 0; i < longIndex; i++) {
            list.add(list.size() >> 2, i);
        }

        System.out.println(longIndex + ":ArrayList 中间插法耗时:" + (System.currentTimeMillis() - time));


        time = System.currentTimeMillis();
        LinkedList<Long> linkedList = new LinkedList<>();
        for (long i = 0; i < longIndex; i++) {
            linkedList.add(linkedList.size() >> 2, i);
        }

        System.out.println(longIndex + ":LinkedList 中间插法耗时:" + (System.currentTimeMillis() - time));
    }

    private static void testTailInsert() {
        testTailInsert((long) Math.pow(10, 5));
        testTailInsert((long) Math.pow(10, 6));
        testTailInsert((long) Math.pow(10, 7));

    }

    private static void testTailInsert(long longIndex) {
        long time = System.currentTimeMillis();
        List<Long> list = new ArrayList<Long>();
        for (long i = 0; i < longIndex; i++) {
            list.add(i);
        }

        System.out.println(longIndex + ":ArrayList 尾插法耗时:" + (System.currentTimeMillis() - time));


        time = System.currentTimeMillis();
        LinkedList<Long> linkedList = new LinkedList<>();
        for (long i = 0; i < longIndex; i++) {
            linkedList.addLast(i);
        }

        System.out.println(longIndex + ":LinkedList 尾插法耗时:" + (System.currentTimeMillis() - time));

    }

    private static void testHeadInsert() {
        testHeadInsert((long) Math.pow(10, 5));
        testHeadInsert((long) Math.pow(10, 6));
        testHeadInsert((long) Math.pow(10, 7));
    }

    private static void testHeadInsert(long longIndex) {
//        long time = System.currentTimeMillis();
//        List<Long> list = new ArrayList<Long>();
//        for (long i = 0; i < longIndex; i++) {
//            list.add(0, i);
//        }
//
//        System.out.println(longIndex + ":ArrayList 头插法耗时:" + (System.currentTimeMillis() - time));
        long time = System.currentTimeMillis();
//        List<Long> list = new ArrayList<Long>();
//        for (long i = 0; i < longIndex; i++) {
//            list.add(0, i);
//        }
//
//        System.out.println(longIndex + ":ArrayList 头插法耗时:" + (System.currentTimeMillis() - time));


        time = System.currentTimeMillis();
        LinkedList<Long> linkedList = new LinkedList<>();
        for (long i = 0; i < longIndex; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(longIndex + ":LinkedList 头插法耗时:" + (System.currentTimeMillis() - time));
    }
}
