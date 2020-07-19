package com.java.study.offer.link;

import java.util.ArrayList;
import java.util.List;

public class JosephuseList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        int deleteNum = 3;

        int lastRemain = findLastRemain(list, deleteNum);
        System.out.println(lastRemain);

    }

    private static int findLastRemain(List<Integer> list, int deleteNum) {
        if (list == null || list.size() == 0) {
            return -1;
        }

        int currentIndex = -1;
        while (list.size() > 1) {
            int count = 0;
            //获取要删除元素的位置
            while (count < deleteNum){
                count ++;
                currentIndex ++;
                if (currentIndex == list.size()){
                    currentIndex = 0;
                }
            }

            list.remove(currentIndex);
            //元素删除之后，位置进行回退
            currentIndex--;

        }
        return list.get(0);

    }
}
