package com.java.study.zuo.vedio.basic.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-24 08:33
 */
public class PaperFolding {

    public static void print(int n) {
        if (n < 0) {
            return;
        }
        int indexLevel = 0;
        boolean downFlag = true;
        print(indexLevel, n, downFlag);

    }

    //中序遍历
    private static void print(int indexLevel, int n, boolean downFlag) {
        if (indexLevel == n) {
            return;
        }
        print(indexLevel + 1, n, true);
        System.out.println(downFlag ? "下" : "上");
        print(indexLevel + 1, n, false);
    }

    public static void main(String[] args) {
        print(3);
    }


}
