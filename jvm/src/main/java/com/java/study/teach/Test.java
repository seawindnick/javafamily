package com.java.study.teach;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/27/21 17:23
 */
public class Test {

    public static void main(String[] args) {

        float i = 0;
        while (i < 10) {
            float value = reserveTwoDecimalPlaces(i);
            String calRule = String.format("租金*租期系数*%.2f（合作系数）", i);
            String calRule2 = "租金*租期系数*" + value + "（合作系数）";
            if (!Objects.equals(calRule, calRule2)) {
                System.out.println(i);
            }
            i = i + 0.0001f;
        }

    }


    /**
     * 保留两位小数
     *
     * @param value
     * @return
     */
    public static Float reserveTwoDecimalPlaces(Float value) {
        return new BigDecimal(value.floatValue()).setScale(2, 4).floatValue();
    }
}
