package com.java.study.interview.chapter1;

import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-13 19:49
 */
public class T01_006Hanoi {


    public static void hanoi(int n) {
        if (n <= 0) {
            return;
        }

        hanoi(n, "左", "右", "中");
    }


    public static void hanoi3(int n, String from, String to, String help) {
        Stack<Integer> fromStack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        Stack<Integer> toStack = new Stack<>();

        for (int i = n; i >= 1; i--) {
            fromStack.push(n);
        }

        while (!(fromStack.isEmpty())){
            Integer value = fromStack.pop();
            //将 n 移动到 help
            helpStack.push(value);

            //将 1~n-1 从右侧移动到左侧
            toStack.push(helpStack.pop());

            //将n从中间移动到右侧
            toStack.push(helpStack.pop());






        }



    }


    public static void hanoi1(int n, String from, String to, String help) {
        if (n == 1) {

            System.out.println("move " + n + " from " + from + " to " + to);
        }

        hanoi(n - 1, from, help, to);

        System.out.println("move " + n + " from " + from + " to " + to);

        hanoi(n - 1, help, to, from);
    }


    /**
     * 必须使用中间杆分五步走
     * 1. n-1 从 from 移动到 to
     * 2. n 从 from 移动到 help
     * 3. n-1 从 to 移动到 from
     * 4. n 从 help 移动到 to
     * 5. n-1 从  from 移动到  to
     *
     * @param n
     * @param from
     * @param to
     * @param help
     */
    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            if (help == "中") {
                System.out.println("move " + n + " from " + from + " to " + help);
                System.out.println("move " + n + " from " + help + " to " + to);
            } else {
                System.out.println("move " + n + " from " + from + " to " + to);
            }
            return;
        }
        int temp = n - 1;
        hanoi(temp, from, to, help);
        System.out.println("move " + n + " from " + from + " to " + help);
        hanoi(temp, to, from, help);
        System.out.println("move " + n + " from " + help + " to " + to);
        hanoi(temp, from, to, help);
    }

    public static void main(String[] args) {
        hanoi1(3, "左", "右", "中");

        System.out.println("--------------");
        hanoi(3);
    }


}
