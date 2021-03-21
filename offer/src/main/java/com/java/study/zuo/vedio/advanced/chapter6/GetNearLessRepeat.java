package com.java.study.zuo.vedio.advanced.chapter6;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-21 22:22
 */
public class GetNearLessRepeat {


    public static class Node {
        private int value;
        private LinkedList<Integer> index = new LinkedList<Integer>();

        public Node(int value, int arrayIndex) {
            this.value = value;
            index.add(arrayIndex);
        }
    }

    public static int[][] getNearLessRepeat(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[][]{};
        }
        int[][] target = new int[arr.length][2];
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            while (!stack.isEmpty() && value <= stack.peek().value) {

                if (value == stack.peek().value) {
                    stack.peek().index.add(i);
                    break;
                }

                Node handleNode = stack.pop();

                int left = -1;
                int right = i;
                if (!stack.isEmpty()) {
                    left = stack.peek().index.getLast();
                }


                while (!handleNode.index.isEmpty()) {
                    Integer handleIndex = handleNode.index.pop();
                    target[handleIndex] = new int[]{left, right};
                }

            }
            stack.add(new Node(value, i));

        }


        while (!stack.isEmpty()) {

            Node handleNode = stack.pop();

            int left = -1;
            int right = -1;
            if (!stack.isEmpty()) {
                left = stack.peek().index.getLast();
            }
            while (!handleNode.index.isEmpty()) {
                Integer handleIndex = handleNode.index.pop();
                target[handleIndex] = new int[]{left, right};
            }
        }

        return target;


    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        System.out.println(JSONArray.toJSONString(getNearLessRepeat(arr)));
    }
}
