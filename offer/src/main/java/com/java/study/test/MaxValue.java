package com.java.study.test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 10:45
 */
public class MaxValue {

    public static int getMaxValue(int[] weight, int[] value, int bag) {
        if (weight == null || weight.length == 0) {
            return 0;
        }
        int indexValue = 0;
        int index = 0;
        int getMaxValue = getMaxValue(weight, value, bag, indexValue, index);
        return getMaxValue;

    }

    private static int getMaxValue(int[] weight, int[] value, int bag, int indexValue, int index) {
        if (index == weight.length) {
            return indexValue;
        }

        if (bag >= weight[index]) {
            return Math.max(getMaxValue(weight, value, bag - weight[index], indexValue + value[index], index + 1),
                    getMaxValue(weight, value, bag, indexValue, index + 1));
        }
        return getMaxValue(weight, value, bag, indexValue, index + 1);
    }

    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5};
        int[] values = {3,4,5,2,1};
        int bag = 5;
        System.out.println(getMaxValue(weight,values,bag));

    }


}
