package com.java.study.offer.string;

public class OneCount {

    public static void main(String[] args) {
        int j = 21045;
        String str = String.valueOf(j);
        int count = cauclateOntCount(str);
        int count2 = cauclateOneCount(str);
        System.out.println(count);
        System.out.println(count2);
    }

    private static int cauclateOneCount(String str) {
        int count = 0;
        for (int i = 0; i <= Integer.parseInt(str); i++) {
            String value = String.valueOf(i);
            char[] array = value.toCharArray();
            for (char c : array) {
                if (c == '1') {
                    count++;
                }
            }
        }
        System.out.println("------" + count);
        return count;
    }

    private static int cauclateOntCount(String str) {
        if (str == null || str.length() == 0 || str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }

        int first = str.charAt(0) - '0';
        int length = str.length();
        if (length == 1 && first == 0) {
            return 0;
        }

        if (length == 1 && first > 0) {
            return 1;
        }

        int count = 0;
        if (first > 1) {
            //高位不为1的时候，1XXXX的次数
            //计算首位为1个时候，1的个数
            count = powerBaseTen(length - 1);
        } else if (first == 1) {
            //高位为1时，1XXXX的次数
            count = Integer.parseInt(str.substring(1)) + 1;
        }

        //长度为31345
        // 3 * 4 * 10*10*10

        //排除首位数据之后，后方随意一个栏位为1，其他栏位都可以从 0-9选择 first * C(length - 1中任意选取一个) * 10^(length - 2) (其他栏位任意选择);
        //计算高位有数据时 其他位为1时，1的个数
        int otherDisits = first * (length - 1) * powerBaseTen(length - 2);

        //计算首位为0时，剩余数据为1 的个数
        int numRecursive = cauclateOntCount(str.substring(1));

        int sum = count + otherDisits + numRecursive;
        System.out.println(sum);
        return sum;


    }

    private static int powerBaseTen(int i) {
        return (int) Math.pow(10, i);
    }


}
