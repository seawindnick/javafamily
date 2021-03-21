package com.java.study.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <Description>
 *
 * @author hushiye
 * @since 12/28/20 10:18
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iterator = list.iterator();
        boolean flag = true;
        while (iterator.hasNext()){

            if (true){
                list.add("4");
                flag = !flag;
            }
            String value = iterator.next();
            System.out.println(value);

        }


    }
}
