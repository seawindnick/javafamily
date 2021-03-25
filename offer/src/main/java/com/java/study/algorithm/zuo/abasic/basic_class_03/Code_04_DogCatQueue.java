package com.java.study.algorithm.zuo.abasic.basic_class_03;

import com.sun.org.apache.bcel.internal.generic.ILOAD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一种狗猫队列的结构，
 * 要求如下: 用户可以调用add方法将cat类或dog类的实例放入队列中;
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例;
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例;
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 */
public class Code_04_DogCatQueue {

    public static class PetZoo {


        private Queue<PetEntity> dogZoo;
        private Queue<PetEntity> catZoo;

        public PetZoo() {
            dogZoo = new LinkedList<>();
            catZoo = new LinkedList<>();
        }

        public void add(Pet pet) {
            if (pet == null) {
                throw new IllegalArgumentException("不能添加空的动物");
            }

            PetEntity petEntity = new PetEntity(pet);
            if ("dog".equals(pet.getPetType())) {
                dogZoo.add(petEntity);
            } else if ("cat".equals(pet.getPetType())) {
                catZoo.add(petEntity);
            }
        }


        public Boolean isEmpty() {
            return dogZoo.isEmpty() && catZoo.isEmpty();
        }

        public Boolean isDogEmpty() {
            return dogZoo.isEmpty();
        }

        public Boolean isCatEmpty() {
            return catZoo.isEmpty();
        }

        public Pet pollCat() {
            if (isCatEmpty()) {
                throw new IllegalArgumentException("猫队列没有元素");
            }

            return catZoo.poll().pet;
        }


        public Pet pollDog() {
            if (isDogEmpty()) {
                throw new IllegalArgumentException("狗队列没有元素");
            }
            return dogZoo.poll().pet;
        }

        public Pet pollAll() {
            if (isEmpty()) {
                throw new IllegalArgumentException("没有元素");
            }

            if (catZoo.isEmpty()) {
                return dogZoo.poll().pet;
            }

            if (dogZoo.isEmpty()) {
                return catZoo.poll().pet;
            }

            return dogZoo.peek().version < catZoo.peek().version ? dogZoo.poll().pet : catZoo.poll().pet;

        }

    }


    public static class PetEntity {
        private Pet pet;
        private int version;

        private static AtomicInteger versionCount = new AtomicInteger(0);

        private int getNextVersion() {
            return versionCount.getAndIncrement();
        }

        public PetEntity(Pet pet) {
            this.pet = pet;
            this.version = getNextVersion();
        }
    }


    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }

    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static void main(String[] args) {
        PetZoo test = new PetZoo();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
//        while (!test.isDogEmpty()) {
//            Pet pet = test.pollDog();
//            System.out.println(pet.getPetType());
//        }
        while (!test.isEmpty()) {
            Pet pet = test.pollAll();
            System.out.println(pet.getPetType());
        }
    }
}