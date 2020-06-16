package com.java.study.chapter5;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class HiddenIterator {
    private static final Set<Integer> set = new HashSet<>();

    public static synchronized void add(Integer i){
        set.add(i);
    }


    public static synchronized void remove(Integer i){
        set.remove(i);
    }



    public static class AddThread extends Thread{
        private Set<Integer> set;

        public AddThread(Set<Integer> set) {
            this.set = set;
        }

        @Override
        public void run() {
            while (true){
                for (int i = 0;i < 10;i++){
                    add(i);
                }
                System.out.println(set);
            }
        }
    }

    public static class DelateThread extends Thread{
        private Set<Integer> set;

        public DelateThread(Set<Integer> set) {
            this.set = set;
        }

        @Override
        public void run() {
            while (true){
                for (int i = 0;i < 10;i++){
                    remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        new AddThread(set).start();;
        new DelateThread(set).start();

    }



    @Data
    public class SchoolExamStatistics{
        private Long schoolId;
        private String schoolName;
        private int totalBySchool;
        private int absentBySchool;
    }



}
