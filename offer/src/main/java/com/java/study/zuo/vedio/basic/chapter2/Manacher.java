package com.java.study.zuo.vedio.basic.chapter2;

/**
 * <Description>
 * 求一个字符串中最大的回文子传
 * 回文半径
 * 回文半径数组 PArr
 * 最右回文边界 R
 * 到达回文最右边界时，其中心点位置 C,多个点都可以到达，记录最早的位置
 * <p>
 * <p>
 * 当前位置不在回文右边界内，暴力破
 * 当前位置i在回文右边界内 ，则必然存在 回文最左边界L与回文最右边界关于中心点C对称， 存在对应的 ii 点与i点呈关于中心点对称
 *
 *
 * <p>
 * 1。 如果ii回文左信息自 左边界内，则ii与i信息一致
 * 2。 如果ii回文左信息在左边界L外，则 i 回文信息为 R-i
 * 3.  如果ii回文左信息在L上 ,继续向下扩展
 *
 *
 * 回文半径：包括回文中心在内的回文子串的一半的长度
 * 回文直径：回文半径的2倍-1 （回文半径包括回文中心）
 *
 *
 * @author hushiye
 * @since 2020-08-19 22:47
 */
public class Manacher {

    //返回的是整个回文串的长度，不是回文半径
    public static int maxLcpsLength2(String str) {
        if (str == null || str.length() < 2) {
            return 0;
        }
        char[] array = str.toCharArray();
        //
        char[] manacherArray = getManacherArray(array);

        int[] pArr = new int[manacherArray.length];
        int centerIndex = -1;
        int r = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < manacherArray.length; i++) {
            //最短回文半径是1
            pArr[i] = r > i ? Math.min(pArr[2 * centerIndex - r], r - i) : 1;

            // i - pArr[i] > -1防止出现左边越界情况
            while (i + pArr[i] < manacherArray.length && i - pArr[i] > -1) {
                if (manacherArray[i + pArr[i]] == manacherArray[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (pArr[i] + i > centerIndex) {
                r = pArr[i] + i;
                centerIndex = i;
            }
            max = Math.max(max, pArr[i]);

        }
        //manacherstring的长度和原字符串不同，所以这里得到的最大回文半径其实是原字符串的最大回文子串长度加1
        return max - 1;

    }


    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        System.out.println(pR);
        return max - 1;
    }


    private static char[] getManacherArray(char[] array) {
        char[] manacherArray = new char[(array.length << 1) + 1];
        int index = 0;
        for (int i = 0; i < manacherArray.length; i++) {
            manacherArray[i] = (i & 1) == 0 ? '$' : array[index++];
        }
        return manacherArray;
    }


    public static int maxLcpsLength(String str) {
        if (str == null || str.length() < 2) {
            return 0;
        }

        String s = "$";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + "$";
        }
        // #A#B#C#D#E#F#
        int[] next = new int[s.length()];
        next[0] = 0;


        int curIndex = 0;
        int maxRightIndex = 0;
        int centerIndex = 0;
        while (curIndex < s.length()) {

            int leftIndex = curIndex - 1;
            int rightIndex = curIndex + 1;
            if (curIndex >= maxRightIndex) {
                int count = 0;
                while (rightIndex < s.length() && leftIndex >= 0 && s.charAt(rightIndex++) == s.charAt(leftIndex--)) {
                    next[curIndex] = ++count;
                    if (rightIndex > maxRightIndex) {
                        maxRightIndex = rightIndex;
                        centerIndex = curIndex;
                    }
                }
            } else {
                int curIndexLeftIndex = centerIndex - (curIndex - centerIndex);
                int half = next[curIndexLeftIndex];

                if (curIndex + half < maxRightIndex) {
                    next[curIndex] = half;
                } else if (curIndex + half > maxRightIndex) {
                    next[curIndex] = maxRightIndex - curIndex;
                } else {
                    int mirrorIndex = curIndex - half;
                    leftIndex = mirrorIndex;
                    rightIndex = maxRightIndex;

                    while (rightIndex < s.length() && leftIndex >= 0 && s.charAt(rightIndex++) == s.charAt(leftIndex--)) {
                        next[curIndex] = ++half;
                        if (rightIndex > maxRightIndex) {
                            maxRightIndex = rightIndex;
                            centerIndex = curIndex;
                        }
                    }
                }
            }

            curIndex++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i = i + 2) {
            max = Math.max(max, next[i] / 2);
        }
        return max;

    }

    public static void main(String[] args) {
        String str1 = "BDABBA";
        System.out.println(maxLcpsLength1(str1));
    }
}
