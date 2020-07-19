package com.java.study.offer.link;

import java.util.ArrayList;
import java.util.List;

public class JosephhuseArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        int deleteNum = 3;
        int last = 0;
        while (list.size() > 1) {
            last = (last + deleteNum - 1) % list.size();
            list.remove(last);
        }

        System.out.println(list.get(0));
    }

    private static int lastRemain(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
