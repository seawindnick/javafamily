package com.java.study.zuo.vedio.basic.chapter8;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-28 08:39
 */
public class WaterProblem {


    public static int waterProblem(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] leftMaxArray = new int[arr.length];


        int preMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            leftMaxArray[i] = Math.max(preMax, arr[i]);
            preMax = leftMaxArray[i];
        }

        int[] rightMaxArray = new int[arr.length];
        preMax = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            rightMaxArray[i] = Math.max(preMax, arr[i]);
            preMax = rightMaxArray[i];
        }

        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = leftMaxArray[i - 1];
            int rightMax = rightMaxArray[i + 1];

            int min = Math.min(leftMax, rightMax);

            if (min < arr[i]) {
                continue;
            }

            sum = sum + (min - arr[i]);

        }
        return sum;
    }


    public static int waterProblem2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];


        int leftIndex = 1;
        int rightIndex = arr.length - 2;

        int sum = 0;
        while (leftIndex <= rightIndex) {
            int leftIndexValue = arr[leftIndex];
            int rightIndexValue = arr[rightIndex];

            if (leftMax <= rightMax) {
                if (leftMax > leftIndexValue) {
                    sum = sum + (leftMax - leftIndexValue);
                }
                leftMax = Math.max(leftMax,leftIndexValue);
                leftIndex++;
            } else {
                if (rightMax > rightIndexValue) {
                    sum = sum + (rightMax - rightIndexValue);
                }
                rightMax = Math.max(rightMax,rightIndexValue);
                rightIndex--;
            }
        }
        return sum;

    }


//    public static int waterProblem2(int[] arr) {
//        if (arr == null || arr.length < 3) {
//            return 0;
//        }
//
//        int sum = 0;
//        int leftMax = arr[0];
//        int rightMax = arr[arr.length - 1];
//
//
//        int leftIndex = 1;
//        int rightIndex = arr.length - 2;
//
//
//        while (leftIndex <= rightIndex) {
//            if (leftMax <= rightMax) {
//                sum += Math.max(0, leftMax - arr[leftIndex]);
//                leftMax = Math.max(leftMax, arr[leftIndex++]);
//            } else {
//                sum += Math.max(0, rightMax - arr[rightIndex]);
//                rightMax = Math.max(rightMax, arr[rightIndex--]);
//            }
//        }
//        return sum;
//
//    }
//
////
////    public static int waterProblem2(int[] arr) {
////        if (arr == null || arr.length < 3) {
////            return 0;
////        }
////        int value = 0;
////        int leftMax = arr[0];
////        int rightMax = arr[arr.length - 1];
////        int l = 1;
////        int r = arr.length - 2;
////        while (l <= r) {
////            if (leftMax <= rightMax) {
////                value += Math.max(0, leftMax - arr[l]);
////                leftMax = Math.max(leftMax, arr[l++]);
////            } else {
////                value += Math.max(0, rightMax - arr[r]);
////                rightMax = Math.max(rightMax, arr[r--]);
////            }
////        }
////        return value;
////    }


    public static int getWater1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return value;
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3,1,2,4};
//        waterProblem2(arr);


        for (int i = 0; i < 1000000; i++) {
            int[] arr = generateRandomArray();
            int r1 = getWater1(arr);
            int r2 = waterProblem2(arr);
            if (r1 != r2) {
                System.out.println(r1);
                System.out.println(r2);
                System.out.println("What a fucking day! fuck that! man!");
            }
        }
//
//        HashMap<String, String> map = new HashMap<String, String>();
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " , " + entry.getValue());
//        }

    }
}
