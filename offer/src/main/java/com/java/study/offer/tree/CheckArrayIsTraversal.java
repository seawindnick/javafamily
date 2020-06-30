package com.java.study.offer.tree;

public class CheckArrayIsTraversal {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,7,8};
        Boolean result = checkArrayIsTraversal(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    private static Boolean checkArrayIsTraversal(int[] arr, int startIndex, int endIndex) {
        if (arr == null || arr.length <= 0) {
            return Boolean.FALSE;
        }

        int rootValue = arr[endIndex];
        //获取右子树数据开始位置
        int rightStartIndex;
        for (rightStartIndex = startIndex; rightStartIndex <= endIndex; rightStartIndex++) {
            if (arr[rightStartIndex] < rootValue) {
                continue;
            }
            break;
        }

        for (int i = startIndex; i < rightStartIndex; i++) {
            if (arr[i] > rootValue) {
                return Boolean.FALSE;
            }
        }

        for (int i = rightStartIndex; i < endIndex; i++) {
            if (arr[i] < rootValue) {
                return Boolean.FALSE;
            }
        }

        //判断左子树
        Boolean leftFlag = true;
        //如果没有左子树
        if (rightStartIndex > 0) {
            leftFlag = checkArrayIsTraversal(arr, startIndex, rightStartIndex - 1);
        }

        //判断右子树
        Boolean rigthFlag = true;
        /**
         * 如果右子树只有一个元素，或者根本没有右子树
         * rightStartIndex == endIndex - 1 时，右子树只有一个元素
         * rightStartIndex == endIndex 时，没有右子树
         */
        if (rightStartIndex < endIndex - 1) {
            rigthFlag = checkArrayIsTraversal(arr, rightStartIndex, endIndex - 1);
        }

        return leftFlag && rigthFlag;
    }
}
