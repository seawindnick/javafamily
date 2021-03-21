package com.java.study.niuke;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-04 10:19
 */
public class Solve {


    public String solve (String str) {
        if (str == null || str.length() <= 1){
            return str;
        }

        char[] array = str.toCharArray();
        int startIndex = 0;
        int endIndex = array.length-1;
        while (startIndex < endIndex){
            char temp = array[endIndex];
            array[endIndex--] = array[startIndex];
            array[startIndex++] = temp;
        }

        return new String(array);

    }

    public static void main(String[] args) {
        String str = "1237";
        Solve solution = new Solve();
        System.out.println(solution.solve(str));
    }
}
