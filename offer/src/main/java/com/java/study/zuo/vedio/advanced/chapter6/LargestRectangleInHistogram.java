package com.java.study.zuo.vedio.advanced.chapter6;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <Description>
 * 获取直方图中最大矩形面积
 *
 * @author hushiye
 * @since 2020-09-21 22:01
 */
public class LargestRectangleInHistogram {

    public static class Node {
        private int value;
        private LinkedList<Integer> index = new LinkedList<Integer>();

        public Node(int value, int arrayIndex) {
            this.value = value;
            index.add(arrayIndex);
        }
    }

    @Data
    public static class Index {
        private int left;
        private int right;

        public Index(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    public static int largestRectangleInHistogram(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] temp = arr[0];
        int maxValue = largestRectangleInHistogram(temp);
        for (int i = 1; i < arr.length; i++) {
            int[] indexArr = arr[i];
            for (int j = 0; j < indexArr.length; j++) {
                temp[j] = indexArr[j] == 0 ? 0 : temp[j] + 1;
            }
            int value = largestRectangleInHistogram(temp);
            System.out.println(JSONArray.toJSONString(temp));
            maxValue = Math.max(maxValue,value);
        }
        return maxValue;

    }

    public static int largestRectangleInHistogram(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        Index[] target = new Index[arr.length];


        Stack<Node> nodeStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            while (!nodeStack.isEmpty() && value <= nodeStack.peek().value) {
                Node node = nodeStack.pop();
                LinkedList<Integer> linkedList = node.index;
                int right = i;
                int left = -1;
                if (!nodeStack.isEmpty()) {
                    left = nodeStack.peek().index.getLast();
                }

                Index index = new Index(left, right);
                for (Integer integer : linkedList) {
                    target[integer] = index;

                }
            }

            if (!nodeStack.isEmpty() && value == nodeStack.peek().value) {
                nodeStack.peek().index.add(i);
            } else {
                Node node = new Node(value, i);
                nodeStack.push(node);
            }

        }


        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            int left = -1;
            int right = -1;
            if (!nodeStack.isEmpty()) {
                left = nodeStack.peek().index.getLast();
            }
            for (Integer integer : node.index) {
                Index index = new Index(left, right);
                target[integer] = index;
            }
        }


        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < target.length; i++) {
            int indexValue = arr[i];
            int left = target[i].left;
            int right = target[i].right;
            if (right == -1) {
                right = target.length;
            }

            int length = right - 1 - left;

            maxValue = Math.max(length * indexValue, maxValue);

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] map = { { 1, 0, 1, 1 },
                        { 1, 1, 1, 1 },
                        { 1, 1, 1, 0 }, };
        System.out.println(largestRectangleInHistogram(map));
    }

}
