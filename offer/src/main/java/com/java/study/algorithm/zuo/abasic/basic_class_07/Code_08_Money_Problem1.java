package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * <Description>
 *
 * @author hushiye
 * @since 4/9/21 15:07
 */
public class Code_08_Money_Problem1 {


    public static boolean Money_Problem(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return false;
        }


        return Money_ProblemUseRecursive(arr, aim, 0, 0);

    }

    private static boolean Money_ProblemUseRecursive(int[] arr, int aim, int index, int result) {
        if (result == aim) {
            return true;
        }

        if (result > aim || index == arr.length) {
            return false;
        }
        return Money_ProblemUseRecursive(arr, aim, index + 1, result) || Money_ProblemUseRecursive(arr, aim, index + 1, result + arr[index]);

    }
}
