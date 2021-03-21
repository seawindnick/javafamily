package com.java.study.basic;

/**
 * <Description>
 *
 * @author hushiye
 * @since 12/27/20 17:35
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "hello world";
        str = str.replace('l','d');
        System.out.println(str);


        str = str.replaceAll("d","l");
        System.out.println(str);


        str = str.replaceFirst("l","");
        System.out.println(str);
    }
}
