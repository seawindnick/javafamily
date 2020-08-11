package com.java.study.zuo.dynamicplanning;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-07 23:23
 */
public class Hanoi {

    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
        } else {
            //将1~n从from移动到help
            hanoi(n - 1, from, help, to);
            //将n从from移动到to
            System.out.println("move " + n + " from " + from + " to " + to);
            //将 help 上 1～n 移动到to 上
            hanoi(n - 1, help, to, from);
        }
    }


    public static void moveLeftToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from 左 to 右");
        }else {
            moveLeftToMid(n - 1);
            System.out.println("move " + n + " from 左 to 右");
            moveMidToRight(n - 1);
        }
    }

    private static void moveMidToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from 中 to 右");
        } else {
            moveMidToLeft(n - 1);
            System.out.println("move " + n + " from 中 to 右");
            moveLeftToRight(n - 1);
        }
    }

    private static void moveMidToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from 中 to 左");
        } else {
            moveMidToRight(n - 1);
            System.out.println("move " + n + " from 中 to 左");
            moveRightToLeft(n - 1);

        }
    }

    private static void moveRightToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from 右 to 左");
        } else {
            moveRightToMid(n - 1);
            System.out.println("move " + n + " from 右 to 左");
            moveMidToLeft(n - 1);
        }
    }

    private static void moveRightToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from 右 to 中");
        } else {
            moveRightToLeft(n - 1);
            System.out.println("move " + n + " from 右 to 中");
            moveLeftToMid(n - 1);
        }

    }

    private static void moveLeftToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from 左 to 中");
        } else {
            moveLeftToRight(n - 1);
            System.out.println("move " + n + " from 左 to 中");
            moveRightToMid(n - 1);
        }
    }


    public static void main(String[] args) {
        hanoi(3, "左", "右", "中");
        System.out.println("--------------");
        moveLeftToRight(3);
    }

}
