package com.java.study.zuo.queue;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.调用add方法，将cat类或Dog类的实例放入队列中
 * 2.调用PollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出
 * 3.调用pollDog方法，将队列中的Dog类实例按照进队列的先后顺序依次弹出
 * 4.调用pollCat方法，将队列中的Cat类实例按照进队列的先后顺序依次弹出
 * 5.调用isEmpty检查队列中是否还有Dog或Cat实例
 * 6.调用isDogEmpty，检查队列中是否有Dog实例
 * 7.调用isCatEmpty，检查队列中是否还有Cat实例
 */
public class DogCatQueue {

    private Queue<Element> dogQueue = new LinkedList<>();
    private Queue<Element> catQueue = new LinkedList<>();
    private int count = 0;


    public void add(Pet pet) {
        Element element = new Element(pet, count++);
        if ("dog".equals(pet.getType())) {
            dogQueue.add(element);
        } else {
            catQueue.add(element);
        }
    }


    public Pet pollAll() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new IllegalArgumentException("没有元素");
        }
        if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }

        if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }

        Element dogElement = dogQueue.peek();
        Element catElement = catQueue.peek();

        return dogElement.getVersion() < catElement.getVersion() ? dogQueue.poll().getPet() : catQueue.poll().getPet();
    }

    public Dog getDog(){
        if (dogQueue.isEmpty()){
            throw new IllegalArgumentException("没有元素");
        }
        return (Dog)dogQueue.poll().pet;
    }


    public Cat getCat(){
        if (catQueue.isEmpty()){
            throw new IllegalArgumentException("没有元素");
        }
        return (Cat)catQueue.poll().pet;
    }


    public Boolean isEmpty(){
        return isCatEmpty() && isDogEmpty();
    }

    public Boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public Boolean isCatEmpty(){
        return catQueue.isEmpty();
    }

    @Data
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
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

    @Data
    public static class Element {
        private Pet pet;
        private int version;

        public Element(Pet pet, int version) {
            this.pet = pet;
            this.version = version;
        }
    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

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
//            System.out.println(test.getDog().getType());
//        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getType());
        }
    }


}
