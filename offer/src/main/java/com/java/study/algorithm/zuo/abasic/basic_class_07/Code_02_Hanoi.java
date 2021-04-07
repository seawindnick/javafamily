package com.java.study.algorithm.zuo.abasic.basic_class_07;
//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制:
//(1) 每次只能移动一个盘子;
//(2) 盘子只能从柱子顶端滑出移到下一根柱子;
//(3) 盘子只能叠在比它大的盘子上。
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
//
// 你需要原地修改栈。
//
// 示例1:
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
//
//
// 示例2:
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
//
//
// 提示:
//
//
// A中盘子的数目不大于14个。
//
// Related Topics 递归
// 👍 88 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code_02_Hanoi {


    public static List<String> hanoi(int n) {
        List<String> list = new ArrayList<>();
        if (n > 0) {
            func(n, n, "左", "中", "右", list);
        }
        return list;
    }

    public static void func(int rest, int down, String from, String help, String to, List<String> list) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
            list.add("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help, list);
            func(1, down, from, help, to, list);
            func(rest - 1, down - 1, help, from, to, list);
        }
    }

    public static List<String> Hanoi(int n) {
        if (n <= 0) {
            return Collections.EMPTY_LIST;
        }

        String start = "左";
        String help = "中";
        String target = "右";
        List<String> list = new ArrayList<>();
        Hanoi(start, target, help, n, list);

        return list;
    }

    private static void Hanoi(String start, String target, String help, int n, List<String> list) {
        if (n == 1) {
            System.out.println("move " + n + " from " + start + " to " + target);
            list.add("move " + n + " from " + start + " to " + target);
        } else {
            Hanoi(start, help, target, n - 1, list);
            System.out.println("move " + n + " from " + start + " to " + target);
            list.add("move " + n + " from " + start + " to " + target);
            Hanoi(help, target, start, n - 1, list);
        }

    }


//    /**
//     * 1.将n-1从 start 移动到 target 辅助空间 help
//     * 2.将n从start移动到help
//     * 3.将n-1从 help 移动到target
//     *
//     * @param start
//     * @param target
//     * @param help
//     * @param n
//     */
//    private static void Hanoi(String start, String target, String help, int n) {
//
//        if (n == 1) {
//            System.out.println("move " + n + " from " + start + " to " + target);
//        } else {
//            Hanoi(start, target, help, n - 1);
//            System.out.println("move " + n + " from " + start + " to " + help);
//            Hanoi(help, target, start, n - 1);
//        }
//    }

    public static void main(String[] args) {
        List<String> list1 = hanoi(4);
        System.out.println("================");
        List<String> list12 = Hanoi(4);

        System.out.println("----------------------");

        if (list1.size() != list12.size()) {
            System.out.println("长度不一样");
            return;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list12.get(i))) {
                System.out.println("数据不一样");
            }

        }

    }
}