package com.java.study.designpattern.simplefactor;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICours iCours = ICoursFactory.getInstance(PythonICours.class);
        iCours.study();
    }
}
