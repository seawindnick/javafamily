package com.java.study.designpattern.simplefactor;

import java.util.Objects;

public class ICoursFactory {

    public static ICours getInstance(Class<? extends ICours> clazz){
        if (Objects.nonNull(clazz)){
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
