package com.java.study;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/11/21 16:26
 */
public class Parent {

    private static final String str = "parent";

    static {
        System.out.println("开始执行父类静态代码块");
        System.out.println(str);
    }

    {
        System.out.println("开始执行父类构造代码块");
    }

    public Parent() {
        System.out.println("执行父类构造函数");
    }
}
