package com.java.study.zuo.vedio.advanced.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 20:57
 */
public class IsSelfCrossing {

    public static Boolean isSelfCrossing(int[] x) {

        if (x == null || x.length < 3) {
            return Boolean.FALSE;
        }


        if (x[0] >= x[2] && x[1] <= x[3] || (x.length >= 4 && ((x[1] > x[3] && x[4] >= x[3]) || (x[1] == x[3] && x[4] + x[0] >= x[2])))) {
            return Boolean.TRUE;
        }

        for (int i = 5; i < x.length; i++) {


            /***
             *
             *               i-3
             *            ----------|
             *            |         |i-4
             *            |         |
             *            |   -------
             *      i-2   |    i-5
             *            |
             *            |_______| i
             *               i-1
             *
             */
            if (x[i - 1] <= x[i - 3] &&
                    ((x[i] >= x[i - 2]) || (x[i - 2] >= x[i - 4] && x[i - 5] + x[i - 1] >= x[i - 3] && x[i - 4] + x[i] >= x[i - 2]))) {
                return true;
            }
        }

        return Boolean.FALSE;


//        if (arr.length == 0){
//            return Boolean.FALSE;
//        }
//
//        if (arr.length < 3){
//            return Boolean.FALSE;
//        }
//
//        if (arr[0] >= arr[2] && arr[1] <= arr[3] || (arr.length > 4 && ((arr[1] >= arr[3] && (arr[4] >= arr[2]) || (arr[3] == arr[1] && arr[4] + arr[0] >= arr[2] ) ) ))){
//            return Boolean.TRUE;
//        }
//
//        for (int i = 5; i < arr.length; i++) {
//            if ( ((arr[i-1]<= arr[i-3] && (arr[i-4] >= arr[i-2]) || (arr[i-3] == arr[i-1] && arr[i-4] + arr[i-0] >= arr[i-2] ) ) )){
//                return Boolean.TRUE;
//            }
//        }
//
//
//
//        return Boolean.FALSE;
    }
}
