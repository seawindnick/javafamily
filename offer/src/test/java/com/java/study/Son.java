package com.java.study;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/11/21 16:26
 */
public class Son extends Parent {

    private static final String str = "son";

    static {
        System.out.println("开始执行子类静态代码块");
        System.out.println(str);
    }

    {
        System.out.println("开始执行父类构造代码块");
    }

    public Son() {
        System.out.println("执行子类构造函数");
    }
}
