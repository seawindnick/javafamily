package com.java.study.interview.chapter1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <Description>
 * 猫狗队列
 * 用户可以调用add方法将cat类或dog类的实例放入队列中
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 * @author hushiye
 * @since 2020-08-13 18:47
 */
public class T01_004CCatDogQueue {

    private int index;
    private Queue<Element> catQueue;
    private Queue<Element> dogQueue;

    public T01_004CCatDogQueue() {
        index = 0;
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }


    public void add(Pet pet) {
        if (pet instanceof Dog) {
            dogQueue.add(new Element(pet, index++));
        } else {
            catQueue.add(new Element(pet, index++));
        }
    }

    public Pet pollAll() {
        if (catQueue.isEmpty() && dogQueue.isEmpty()) {
            throw new IllegalArgumentException("无元素");
        }

        if (dogQueue.isEmpty()) {
            return catQueue.poll().pet;
        }

        if (catQueue.isEmpty()) {
            return dogQueue.poll().pet;
        }

        return catQueue.peek().index < dogQueue.peek().index ? catQueue.poll().pet : dogQueue.poll().pet;
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new IllegalArgumentException("无元素");
        }
        return (Dog) dogQueue.poll().pet;
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new IllegalArgumentException("无元素");
        }
        return (Cat) catQueue.poll().pet;
    }

    public Boolean isEmpty() {
        return isDogEmpty() && isCatEmpty();
    }

    public Boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public Boolean isCatEmpty() {
        return catQueue.isEmpty();
    }


    @Data
    @AllArgsConstructor
    public static class Pet {
        private String type;
    }


    public static class Dog extends Pet {
        public Dog(String type) {
            super("dog");
        }
    }

    public static class Cat extends Pet {

        public Cat(String type) {
            super("cct");
        }
    }

    @Data
    @AllArgsConstructor
    public static class Element {
        private Pet pet;
        private int index;
    }


}
