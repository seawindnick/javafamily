package com.java.study.chapter3;

public class Final {

    public static void main(String[] args) {
        final StringBuilder stringBuilder = new StringBuilder();
        initStringBuilder(stringBuilder);
        System.out.println("-----");
        System.out.println(stringBuilder.toString());
        System.out.println("00000");
    }

    private static void initStringBuilder(StringBuilder stringBuilder) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("哈哈");
        System.out.println(stringBuilder.toString());
    }
}
