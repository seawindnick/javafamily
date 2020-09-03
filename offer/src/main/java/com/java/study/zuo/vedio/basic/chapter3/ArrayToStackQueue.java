package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 * 用数组实现队列和栈
 *
 * @author hushiye
 * @since 2020-08-22 14:50
 */
public class ArrayToStackQueue {

    /**
     * 数组实现队列，先进先出
     */
    public static class ArrayImplementsQueue {

        private int[] array;
        private int size;
        private int startIndex;
        private int endIndex;

        public ArrayImplementsQueue(int size) {
            this.size = 0;
            array = new int[size];
            startIndex = 0;
            endIndex = 0;
        }

        public void add(int value) {
            if (size == array.length) {
                throw new IllegalArgumentException("数组已经填满数据");
            }
            array[endIndex] = value;
            endIndex = endIndex == array.length - 1 ? 0 : endIndex+1;
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new IllegalArgumentException("没有元素");
            }
            int value = array[startIndex];
            startIndex = startIndex == array.length - 1 ? 0 : startIndex+1;
            size--;
            return value;
        }


        public static class ArrayImplementsStack {
            private int[] array;
            private int size;
            private int endIndex;


            public ArrayImplementsStack(int size) {
                this.size = 0;
                array = new int[size];
            }

            public void push(int value) {
                if (size == array.length) {
                    throw new IllegalArgumentException("数组已经填满数据");
                }
                array[endIndex++] = value;
                size++;
            }

            public int pop() {
                if (size == 0) {
                    throw new IllegalArgumentException("没有元素");
                }
                size--;
                return array[--endIndex];
            }
        }
    }


    public static void main(String[] args) {
//        ArrayImplementsQueue arrayImplementsQueue = new ArrayImplementsQueue(3);
//        arrayImplementsQueue.add(1);
//        arrayImplementsQueue.add(2);
//        System.out.println(arrayImplementsQueue.pop());
//        arrayImplementsQueue.add(3);
//        arrayImplementsQueue.add(4);
//        System.out.println(arrayImplementsQueue.pop());
//        System.out.println(arrayImplementsQueue.pop());
//        System.out.println(arrayImplementsQueue.pop());


        ArrayImplementsQueue.ArrayImplementsStack arrayImplementsStack = new ArrayImplementsQueue.ArrayImplementsStack(3);
        arrayImplementsStack.push(1);
        arrayImplementsStack.push(2);
        System.out.println(arrayImplementsStack.pop());
        arrayImplementsStack.push(3);
        arrayImplementsStack.push(4);
        System.out.println(arrayImplementsStack.pop());
        System.out.println(arrayImplementsStack.pop());
        System.out.println(arrayImplementsStack.pop());

    }


}
