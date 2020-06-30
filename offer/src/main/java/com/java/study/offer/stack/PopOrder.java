package com.java.study.offer.stack;

import java.util.Objects;
import java.util.Stack;

public class PopOrder {

    public static void main(String[] args) {
        int[] pushArray = new int[]{1, 2, 3, 4, 5};
        int[] popArray = new int[]{4, 5, 3, 1, 2};
        Boolean flag = checkPopOrder(pushArray, popArray);
        System.out.println(flag);
    }

    private static Boolean checkPopOrder(int[] pushArray, int[] popArray) {
        if (Objects.isNull(pushArray) || Objects.isNull(popArray)) {
            return Boolean.FALSE;
        }


        Stack<Integer> stack = new Stack();


        int startPushArrayIndex = 0;
        int startPopArrayIndex = 0;
        while (startPushArrayIndex < pushArray.length) {
            while (stack.isEmpty() || stack.peek() != popArray[startPopArrayIndex]) {
                if (startPushArrayIndex > pushArray.length - 1) {
                    break;
                }

                stack.push(pushArray[startPushArrayIndex]);
                startPushArrayIndex++;
            }


            while (!stack.isEmpty()) {
                if (stack.peek() != popArray[startPopArrayIndex]) {
                    break;
                }
                stack.pop();
                startPopArrayIndex++;
            }

        }
        return stack.empty();
    }
}
