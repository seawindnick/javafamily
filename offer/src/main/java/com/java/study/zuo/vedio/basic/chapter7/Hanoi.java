package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 23:24
 */
public class Hanoi {


    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, help, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        hanoi(n - 1, help, to, from);
    }


    public static void main(String[] args) {
        hanoi(3,"左","右","中");
    }

}
