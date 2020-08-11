package com.java.study.zuo.array;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-07 08:53
 */
public class BestArrange {


    public static int getBestArrange(Node[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }



        int count = 0;

        PriorityQueue<Node> minEndQueue = new PriorityQueue<>(new MinComparator());
        for (Node node : arr) {
            minEndQueue.add(node);
        }

        int curTime = 0;
        while (count <= 24 && !minEndQueue.isEmpty()){
            Node node = minEndQueue.poll();
            if (curTime <= node.startDate ){
                count++;
                curTime = node.endDate;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        Node node = new Node(0,6);
        nodes[0] = node;

        node = new Node(1,5);
        nodes[1] = node;

        node = new Node(0,3);
        nodes[2] = node;

        node = new Node(3,4);
        nodes[3] = node;


        node = new Node(4,5);
        nodes[4] = node;


        System.out.println(getBestArrange(nodes));
    }


    public static class MinComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.endDate.compareTo(o2.endDate);
        }
    }


    @Data
    public static class Node{
        private Integer startDate;
        private Integer endDate;

        public Node(Integer startDate, Integer endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}
