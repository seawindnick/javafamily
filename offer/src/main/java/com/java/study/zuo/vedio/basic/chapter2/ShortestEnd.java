package com.java.study.zuo.vedio.basic.chapter2;

/**
 * <Description>
 * 给定一个字符串，往字符串后添加字符编程str2,要求整体回文，且最短
 *
 * @author hushiye
 * @since 2020-08-20 22:43
 */
public class ShortestEnd {


    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            if (pR == charArr.length) {
                maxContainsEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = charArr[i * 2 + 1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "abba";
        System.out.println(shortestEnd(str2));

    }
//
//
//
//    public static String shortestEnd(String str) {
//        if (str == null) {
//            return null;
//        }
//
//        char[] manacherArray = getManacherArray(str);
//        int maxCenterIndex = searchMaxCenterIndex(manacherArray);
//        int leftIndex = 2 * maxCenterIndex - (manacherArray.length - 1);
//        for (int i = leftIndex; i >= 0; i--) {
//            if ((i & 1) != 0) {
//                str += manacherArray[i];
//            }
//        }
//        return str;
//    }
//
//    /**
//     * @param manacherArray
//     * @return
//     */
//    private static int searchMaxCenterIndex(char[] manacherArray) {
//        int[] pArr = new int[manacherArray.length];
//        int pR = -1;
//        int cIndex = -1;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < manacherArray.length && pR < manacherArray.length; i++) {
//            pArr[i] = pR > i ? Math.min(pArr[2 * cIndex - i], pR - i) : 1;
//
//            while (i + pArr[i] < manacherArray.length && i - pArr[i] > -1) {
//                if (manacherArray[i + pArr[i]] == manacherArray[i - pArr[i]]) {
//                    pArr[i]++;
//                } else {
//                    break;
//                }
//            }
//
//            if (i + pArr[i] > pR) {
//                pR = i + pArr[i];
//                cIndex = i;
//            }
//            max = Math.max(max, pArr[i] / 2);
//        }
//
//        return cIndex;
//    }
//
//    private static char[] getManacherArray(String str) {
//        char[] array = str.toCharArray();
//        char[] manacherArray = new char[(str.length() << 1) + 1];
//        int index = 0;
//        for (int i = 0; i < manacherArray.length; i++) {
//            manacherArray[i] = (i & 1) == 0 ? '$' : array[index++];
//        }
//        return manacherArray;
//    }
//
//    public static char[] manacherString(String str) {
//        char[] charArr = str.toCharArray();
//        char[] res = new char[str.length() * 2 + 1];
//        int index = 0;
//        for (int i = 0; i != res.length; i++) {
//            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
//        }
//        return res;
//    }
//
//    public static String shortestEnd2(String str) {
//        if (str == null || str.length() == 0) {
//            return null;
//        }
//        char[] charArr = manacherString(str);
//        int[] pArr = new int[charArr.length];
//        int index = -1;
//        int pR = -1;
//        int maxContainsEnd = -1;
//        for (int i = 0; i != charArr.length; i++) {
//            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
//            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
//                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
//                    pArr[i]++;
//                else {
//                    break;
//                }
//            }
//            if (i + pArr[i] > pR) {
//                pR = i + pArr[i];
//                index = i;
//            }
//            if (pR == charArr.length) {
//                //获取最大的回文半径
//                maxContainsEnd = pArr[i];
//                break;
//            }
//        }
//        char[] res = new char[str.length() - maxContainsEnd + 1];
//        for (int i = 0; i < res.length; i++) {
//            res[res.length - 1 - i] = charArr[i * 2 + 1];
//        }
//        return String.valueOf(res);
//    }
//
//    public static void main(String[] args) {
//        String str2 = "BABA";
//        System.out.println(shortestEnd2(str2));
//
//    }

//    public static void main(String[] args) {
//        String str = "BDABBA";
//        System.out.println(shortestEnd(str));
//    }


}
