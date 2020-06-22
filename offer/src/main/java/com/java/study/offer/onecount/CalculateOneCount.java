package com.java.study.offer.onecount;

public class CalculateOneCount {
    public static void main(String[] args) {
        int i = -9;
        int count = calculateOneCount(i);
        System.out.println(count);

    }

    private static int calculateOneCount(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i = (i - 1) & i;
        }
        return count;
    }

//    private static int calculateOneCount(int i) {
//
//        int count = 0;
//        int check = 1;
//        while (check != 0){
//            if ((i & check) != 0){
//                ++ count ;
//            }
//            check = check << 1;
//        }
//        return count;
//    }


//    private static int calculateOneCount(int i) {
//        int count = 0;
//        while (i != 0) {
//            if ((i & 1) == 1) {
//                count++;
//            }
//            i = i >> 1;
//            System.out.println(i);
//        }
//
//        return count;
//    }
}
