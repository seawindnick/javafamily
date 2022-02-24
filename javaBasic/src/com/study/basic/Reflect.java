package com.study.basic;

import java.lang.reflect.Field;

/**
 * <Description>
 *
 * @author hushiye
 * @since 11/5/21 22:40
 */
public class Reflect {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        new TestApp().play();
//        testPlay(HahaTestApp.class);
        testVoidPlay();

    }

    public static class TestApp {
        public void play() {
            System.out.println("haha");
        }
    }

    public static class HahaTestApp extends TestApp {
        public void play() {
            System.out.println("HahaTestApp");
        }
    }


    public static void testPlay(Class<? extends TestApp> clazz) throws IllegalAccessException, InstantiationException {
        TestApp object = clazz.newInstance();
        object.play();

    }


    public static void testVoidPlay() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("李雷", 12);

        Class clazz = person.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            System.out.println(field.getName());
            field.setAccessible(true);
            System.out.println( field.get(person));
        }

//
//        Field field = clazz.getDeclaredField("age");
//        field.setAccessible(true);
//
//        System.out.println( field.get(person));


    }




}
