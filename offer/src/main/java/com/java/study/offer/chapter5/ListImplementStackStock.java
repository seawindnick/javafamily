package com.java.study.offer.chapter5;

import java.util.ArrayList;
import java.util.List;

public class ListImplementStackStock {
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();


    public void add(String str) {
        List addList = list1.size() == 0 ? list2 : list1;
        addList.add(str);
    }


    public String pop(){
        List<String> popList = list1.size() == 0 ? list2 : list1;
        if (popList.size() == 0){
            throw new RuntimeException("没有元素");
        }

        List<String> newPopList = list1.size() == 0 ? list1 : list2;
        for (int i = 0; i < popList.size(); i++) {
            String str = popList.get(i);
            if (i != popList.size() - 1){
                newPopList.add(str);
            }else {
                popList.clear();
                return str;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListImplementStackStock listImplementStackStock = new ListImplementStackStock();
        for (int i = 0; i < 10 ; i++) {
            listImplementStackStock.add(String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(listImplementStackStock.pop());
        }


        for (int i = 0; i < 10 ; i++) {
            listImplementStackStock.add(String.valueOf("测试"+i));
        }


        for (int i = 0; i < 15; i++) {
            System.out.println(listImplementStackStock.pop());
        }

    }

}
