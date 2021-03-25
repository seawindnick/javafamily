package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 使用数组实现栈
 * 先进后出
 */
public class Code_01_Array_To_Stack_Queue {

    public static class ArrayToStack {
        private int length;
        private Object[] arr;
        private int size;

        public ArrayToStack(int length) {
            this.length = length;
            arr = new Object[length];
            size = 0;
        }

        private void add(Object obj) {
            if (size == length) {
                throw new IllegalArgumentException("已经达到上线");
            }
            arr[size++] = obj;
        }


        private Object pop() {
            if (size == 0) {
                throw new IllegalArgumentException("没有元素可以获取");
            }
            Object result = arr[--size];
            return result;
        }

    }

    public static class ArrayToQueue {
        private int length;
        private Object[] arr;
        private int size;
        private int headIndex;
        private int tailIndex;

        public ArrayToQueue(int length) {
            this.length = length;
            arr = new Object[length];
        }


        public void add(Object object) {
            if (size == length) {
                throw new IllegalArgumentException("已经达到上线");
            }
            arr[tailIndex] = object;
            tailIndex = tailIndex == length - 1 ? 0 : tailIndex + 1;
            size++;
        }

        public Object get() {
            if (size == 0) {
                throw new IllegalArgumentException("没有元素可以获取");
            }
            --size;
            Object object = arr[headIndex];
            headIndex = headIndex == length - 1 ? 0 : headIndex + 1;

            return object;
        }
    }


    public static void main(String[] args) {
//        ArrayToQueue arrayToQueue = new ArrayToQueue(10);
//        for (int i = 0; i < 10; i++) {
//            arrayToQueue.add(i);
//
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayToQueue.get());
//        }
//
//        for (int i = 0; i < 10; i++) {
//            arrayToQueue.add(i);
//
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayToQueue.get());
//        }

//        ArrayToStack arrayToQueue = new ArrayToStack(10);
//        for (int i = 0; i < 10; i++) {
//            arrayToQueue.add(i);
//
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayToQueue.pop());
//        }
//
//        for (int i = 0; i < 10; i++) {
//            arrayToQueue.add(i);
//
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayToQueue.pop());
//        }

    }


}