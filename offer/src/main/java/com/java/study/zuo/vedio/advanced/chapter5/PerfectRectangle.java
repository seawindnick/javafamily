package com.java.study.zuo.vedio.advanced.chapter5;

import java.util.HashSet;
import java.util.Set;

/**
 * <Description>
 * <p>
 * rectangles [1,1,3,3], [3,1,4,2], [3,2,4,4], [1,3,2,4], [2,3,3,4]]
 * 其中，
 * [1,1,3,3]表示第1个矩形左上角的坐标为(1,1)，
 * 右下角的坐标为(3,3)
 * [3,1,4,2]表示第2个矩形左上角的坐标为(3,1)，
 * 右下角的坐标为(4,2)
 * ... 按照这种方法可以给你几组矩形，请判断他们能不能正好组成一个完整的大矩形，
 * 且没 有重合的部分。
 *
 * @author hushiye
 * @since 2020-09-17 16:05
 */
public class PerfectRectangle {

    public static Boolean rectangles(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return false;
        }

        Set<String> set = new HashSet<>();

        int rowLength = rectangles.length;

        int mostLeftX = Integer.MAX_VALUE;
        int mostLeftY = Integer.MAX_VALUE;

        int mostRightX = Integer.MIN_VALUE;
        int mostRightY = Integer.MIN_VALUE;

        int area = 0;

        for (int row = 0; row < rowLength; row++) {
            int[] rowArr = rectangles[row];
            int leftX = rowArr[0];
            int leftY = rowArr[1];

            int rightX = rowArr[2];
            int rightY = rowArr[3];
            area += ((rightY - leftY) * (rightX - leftX));

            mostLeftX = Math.min(mostLeftX,leftX);
            mostLeftY = Math.min(mostLeftY,leftY);

            mostRightX = Math.max(mostRightX,rightX);
            mostRightY = Math.max(mostRightY,rightY);


            calculatePoint(leftX, leftY, set);
            calculatePoint(leftX, rightY, set);
            calculatePoint(rightX, leftY, set);
            calculatePoint(rightX, rightY, set);

        }

        if (!set.contains(getKey(mostLeftX, mostLeftY)) || !set.contains(getKey(mostLeftX, mostRightY))
                || !set.contains(getKey(mostRightX, mostLeftY)) || !set.contains(getKey(mostRightX, mostRightY)) || set.size() != 4) {
            return false;
        }

        return area == (mostRightY - mostLeftY) * (mostRightX-mostLeftX);

    }

    private static String getKey(int x, int y) {
        String key = x + "_" + y;
        return key;
    }

    private static void calculatePoint(int x, int y, Set<String> set) {
        String key = getKey(x, y);
        if (set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(rectangles(arr));

    }
}
