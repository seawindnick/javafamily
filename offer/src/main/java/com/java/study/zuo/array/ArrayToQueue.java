package com.java.study.zuo.array.array;

/**
 * 使用数据实现队列
 */
public class ArrayToQueue {

    private int[] arr;
    //数组最大长度
    private int length;

    //数组已经拥有数据长度
    private int size;

    private int searchIndex;

    //添加数据应该在的位置
    private int insertIndex;


    public ArrayToQueue(int length) {
        this.length = length;
        arr = new int[length];
        size = 0;
        searchIndex = 0;
        insertIndex = 0;
    }


    public void add(Integer value) {
        if (size == length) {
            throw new IllegalArgumentException("队列已经全部填充数据，不能再添加元素");
        }

        arr[insertIndex] = value;
        insertIndex = insertIndex == length - 1 ? 0 : ++insertIndex;
        size++;
    }

    //先进先出
    public int pop() {

        if (size == 0) {
            throw new IllegalArgumentException("集合中无元素");
        }
        int value = arr[searchIndex];
        searchIndex = searchIndex == length - 1 ? 0 : ++searchIndex;
        size--;
        return value;
    }

    public int peep() {
        if (size == 0) {
            throw new IllegalArgumentException("集合中无元素");
        }
        return arr[searchIndex];
    }


    public static void main(String[] args) {
        ArrayToQueue arrayToQueue = new ArrayToQueue(10);

        for (int i = 0; i < 10; i++) {
            arrayToQueue.add(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayToQueue.pop());
        }

        for (int i = 0; i < 5; i++) {
            arrayToQueue.add(i);
        }


        for (int i = 0; i < 11; i++) {
            System.out.println(arrayToQueue.pop());
        }

    }





}
