package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

/**
 * 一个人开始在(0,0)，总是第一次走向上方，
 * 第二次走向左方，第三次走向下方， 第四次走向右方，第五次走向上方，
 * 第六次走向左方，第七次走向下方，第八 次走向右方，第九次走向上方...依次走下去。 给定一个数组arr，arr[i]表示第i次走的步数。
 * 请返回，按照数组的步数走，会不会让走过的路径交叉在一起。
 *
 * https://www.processon.com/diagraming/6086e69be401fd5111e16131
 *
 */
public class Code_06_Self_Crossing {

    public static boolean Self_Crossing(int[] arr) {
        if (arr == null || arr.length <= 3) {
            return false;
        }

        if (arr.length >= 4 && (arr[3] >= arr[1] && arr[0] >= arr[2])) {
            return true;
        }

        for (int i = 4; i < arr.length; i++) {
            if (arr[i] + arr[i - 4] >= arr[i - 2] && arr[i - 1] == arr[i - 3]) {
                return true;
            }

            if (arr[i - 1] <= arr[i - 3] && arr[i - 2] <= arr[i]) {
                return true;
            }

            if (i >= 5 && arr[i] + arr[i - 4] >= arr[i - 2] && arr[i - 1] + arr[i - 5] >= arr[i - 3] && arr[i - 2] >= arr[i - 4] && arr[i - 3] >= arr[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 2, 1, 1};
        System.out.println(Self_Crossing(arr));
        System.out.println(com.java.study.answer.zuo.dadvanced.advanced_class_02.Code_06_Self_Crossing.isSelfCrossing(arr));
    }

}