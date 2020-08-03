package com.java.study.zuo.tree;

/**
 * 折纸问题
 */
public class PaperFolding {

    public static void printAllFolds(int n){
        printProcess(1,n,true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N){
            return;
        }
        printProcess(i+1,N,true);
        System.out.println(down ? "down" :"up");
        printProcess(i+1,N,false);
    }

    public static void main(String[] args) {
        int n = 2;
        printAllFolds(3);
    }

}
