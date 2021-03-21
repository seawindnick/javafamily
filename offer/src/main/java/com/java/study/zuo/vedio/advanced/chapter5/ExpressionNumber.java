package com.java.study.zuo.vedio.advanced.chapter5;

import lombok.Data;

/**
 * <Description>
 * 表达式得到期望结果的组成种数
 * 【题目】 给定一个只由0(假)、1(真)、&(逻辑与)、|(逻辑或)和^(异或)五种字符组成的字符 串express，再给定一个布尔值desired。返回express能有多少种组合方式，可以达到 desired的结果。
 * 【举例】
 * express="1^0|0|1"，desired=false。
 * 只有1^((0|0)|1)和1^(0|(0|1))的组合可以得到false，返回2。 express="1"，desired=false。
 * 无组合则可以得到false，返回0。
 *
 * @author hushiye
 * @since 2020-09-15 20:17
 */
public class ExpressionNumber {

    @Data
    public static class ExpressResult {
        private int falseCount;
        private int trueCount;

        public ExpressResult(int falseCount, int trueCount) {
            this.falseCount = falseCount;
            this.trueCount = trueCount;
        }
    }


    /**
     * 1^0|0|1
     *
     * @param express
     * @param flag
     * @return 基数位都是运算符
     */
    public static int expressionNumber(String express, Boolean flag) {
        if (express == null || express.length() == 0) {
            return 0;
        }

        char[] array = express.toCharArray();
        ExpressResult result = expressionNumber(array, 0, array.length - 1);


        return flag ? result.trueCount : result.falseCount;
    }

    private static ExpressResult expressionNumber(char[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            int falseCount = array[startIndex] == '1' ? 0 : 1;
            int trueCount = array[startIndex] == '1' ? 1 : 0;
            return new ExpressResult(falseCount, trueCount);
        }

        int trueCount = 0;
        int falseCount = 0;
        for (int i = startIndex + 1; i <= endIndex; i += 2) {
            char indexOperater = array[i];
            ExpressResult leftResult = expressionNumber(array, startIndex, i - 1);
            ExpressResult rightResult = expressionNumber(array, i + 1, endIndex);
            int leftFalseCount = leftResult.falseCount;
            int leftTrueCount = leftResult.trueCount;

            int rightFalseCount = rightResult.falseCount;
            int rightTrueCount = rightResult.trueCount;
            if (indexOperater == '^') {
                trueCount += leftFalseCount * rightTrueCount + leftTrueCount * rightFalseCount;
                falseCount += leftTrueCount * rightTrueCount + leftFalseCount * rightFalseCount;
            } else if (indexOperater == '&') {
                trueCount += leftTrueCount * rightTrueCount;
                falseCount += leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount + leftFalseCount * rightFalseCount;
            } else if (indexOperater == '|') {
                trueCount += leftTrueCount * rightTrueCount + leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount;
                falseCount += leftFalseCount * rightFalseCount;
            }

        }
        return new ExpressResult(falseCount, trueCount);
    }

    public static int num2(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;
        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '0' ? 0 : 1;
            f[i][i] = exp[i] == '1' ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (exp[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length - 1] : f[0][f.length - 1];
    }


    public static int expressionNumber3(String express, Boolean flag) {
        if (express == null || express.length() == 0) {
            return 0;
        }
        char[] array = express.toCharArray();

        int length = express.length();
        int[][] falseMatix = new int[length][length];
        int[][] trueMatix = new int[length][length];

        for (int i = 0; i < length; i += 2) {
            falseMatix[i][i] = array[i] == '0' ? 1 : 0;
            trueMatix[i][i] = array[i] == '1' ? 1 : 0;
        }

        //行从下向上
        for (int row = length - 3; row >= 0; row -= 2) {
            for (int col = row + 2; col < length; col += 2) {
                int trueCount = 0;
                int falseCount = 0;
                for (int spilt = row + 1; spilt < length; spilt += 2) {
                    char indexOperater = array[spilt];

                    int leftFalseCount = falseMatix[row][spilt - 1];
                    int leftTrueCount = trueMatix[row][spilt - 1];

                    int rightFalseCount = falseMatix[spilt + 1][col];
                    int rightTrueCount = trueMatix[spilt + 1][col];

                    if (indexOperater == '^') {
                        trueCount += leftFalseCount * rightTrueCount + leftTrueCount * rightFalseCount;
                        falseCount += leftTrueCount * rightTrueCount + leftFalseCount * rightFalseCount;
                    } else if (indexOperater == '&') {
                        trueCount += leftTrueCount * rightTrueCount;
                        falseCount += leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount + leftFalseCount * rightFalseCount;
                    } else if (indexOperater == '|') {
                        trueCount += leftTrueCount * rightTrueCount + leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount;
                        falseCount += leftFalseCount * rightFalseCount;
                    }

                }

                falseMatix[row][col] = falseCount;
                trueMatix[row][col] = trueCount;
            }

        }


        return flag ? trueMatix[0][trueMatix[0].length - 1] : falseMatix[0][trueMatix[0].length - 1];

    }


    public static int expressionNumber2(String express, Boolean flag) {
        if (express == null || express.length() == 0) {
            return 0;
        }
        char[] array = express.toCharArray();

        int length = express.length();
        int[][] falseMatix = new int[length][length];
        int[][] trueMatix = new int[length][length];


        falseMatix[0][0] = array[0] == '0' ? 1 : 0;
        trueMatix[0][0] = array[0] == '1' ? 1 : 0;


        for (int i = 2; i < length; i += 2) {
            falseMatix[i][i] = array[i] == '0' ? 1 : 0;
            trueMatix[i][i] = array[i] == '1' ? 1 : 0;
            for (int j = i - 2; j >= 0; j = j - 2) {
                for (int k = j; k < i; k = k + 2) {
                    char indexOp = array[k + 1];

                    int leftFalse = falseMatix[j][k];
                    int leftTrue = trueMatix[j][k];

                    int rightFlase = falseMatix[k + 2][i];
                    int rightTrue = trueMatix[k + 2][i];

                    if (indexOp == '&') {
                        trueMatix[j][i] = trueMatix[j][i] + leftTrue * rightTrue;
                        falseMatix[j][i] = falseMatix[j][i] + leftFalse * rightFlase + leftTrue * rightFlase + leftFalse * rightTrue;
                    } else if (indexOp == '^') {
                        trueMatix[j][i] = trueMatix[j][i] + leftFalse * rightTrue + leftTrue * rightFlase;
                        falseMatix[j][i] = falseMatix[j][i] + leftFalse * rightFlase + leftTrue * rightTrue;

                    } else if (indexOp == '|') {
                        trueMatix[j][i] = trueMatix[j][i] + leftFalse * rightTrue + leftTrue * rightTrue + leftTrue * rightFlase;
                        falseMatix[j][i] = falseMatix[j][i] + leftFalse * rightFlase;
                    }

                }
            }

        }

        return flag ? trueMatix[0][trueMatix[0].length - 1] : falseMatix[0][trueMatix[0].length - 1];

    }


    public static int num1(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        return p(exp, desired, 0, exp.length - 1);
    }

    public static int p(char[] exp, boolean desired, int l, int r) {
        if (l == r) {
            if (exp[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String express = "1^0&0|1&1^0&0^1|0|1&1";
        boolean desired = true;
        System.out.println(expressionNumber(express, desired));
        System.out.println(num1(express, desired));
        System.out.println(expressionNumber2(express, desired));
        System.out.println(expressionNumber3(express, desired));

    }
}
