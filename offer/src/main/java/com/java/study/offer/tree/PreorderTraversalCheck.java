package com.java.study.offer.tree;

public class PreorderTraversalCheck {

    public static void main(String[] args) {
        int[] arr = new int[]{10,6,4,8,14,12,16};
        Boolean result = preorderTraversalCheck(arr, 0, arr.length - 1);
        System.out.println(result);


    }

    private static Boolean preorderTraversalCheck(int[] arr, int startIndex, int endIndex) {
        if (arr == null || arr.length == 0) {
            return Boolean.FALSE;
        }


        int rootValue = arr[startIndex];

        //获取右节点开始位置
        int rightStartIndex = startIndex;
        for (; rightStartIndex <= endIndex; rightStartIndex++) {
            if (arr[rightStartIndex] > rootValue) {
                break;
            }
        }

        //由于左边节点在获取右子树开始的数据时已经校验，无需再次校验

        // 判断右边节点数据是否大于根节点即可
        for (int i = rightStartIndex; i <= endIndex; i++) {
            if (arr[i] < rootValue) {
                return Boolean.FALSE;
            }
        }


        boolean leftFlag = Boolean.TRUE;
        //有左子树
        if (rightStartIndex > startIndex + 1) {
            leftFlag = preorderTraversalCheck(arr, startIndex + 1, rightStartIndex - 1);
        }

        Boolean rightFlag = Boolean.TRUE;
        //有右子树
        if (rightStartIndex < endIndex) {
            rightFlag = preorderTraversalCheck(arr, rightStartIndex, endIndex);
        }

        return leftFlag && rightFlag;
    }


}
