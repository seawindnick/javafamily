package com.java.study.basic;

import org.apache.shiro.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <Description>
 *
 * @author hushiye
 * @since 12/27/20 17:44
 */
public class LongTest {


    public static void main(String[] args) {
        Long l1 = 123L;
        Long l2 = 123L;
        System.out.println(l1 == l2);

        Long l3 = new Long(123);
        Long l4 = new Long (123);
        System.out.println(l3 == l4);

        List<String> list = new ArrayList<>();

        Collections.unmodifiableList(list);
    }
}
