package com.java.study.algorithm.zuo.abasic.basic_class_04;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.快速查询两个元素是否属于一个集合
 * 2.两个元素所在集合合并在一起
 */
public class Code_09_UnionFind {


    public static class Node {

    }

//
//    public static class UnionFind {
//        /**
//         * 节点与其父节点映射关系
//         */
//        private Map<Node, Node> parentMap;
//        /**
//         * 节点所在集合数量
//         */
//        private Map<Node, Integer> sizeMap;
//
//
//        public void add(Node node) {
//            sizeMap.put(node, 1);
//            parentMap.put(node, node);
//        }
//
//
//        public void merge(Node node1, Node node2) {
//            Node targetNode = sizeMap.get(node1) > sizeMap.get(node2) ? node1 : node2;
//            Node addNode = sizeMap.get(node1) > sizeMap.get(node2) ? node2 : node1;
//
//            Node publicParentNode = targetNode;
//            while (publicParentNode != parentMap.get(publicParentNode)) {
//                publicParentNode = parentMap.get(publicParentNode);
//            }
//
//            while (addNode != parentMap.get(addNode)) {
//                parentMap.put(addNode, publicParentNode);
//                sizeMap.put(publicParentNode, sizeMap.get(publicParentNode) + 1);
//                sizeMap.remove(addNode);
//                addNode = parentMap.get(addNode);
//            }
//
//            sizeMap.put(publicParentNode, sizeMap.get(publicParentNode) + 1);
//            sizeMap.remove(addNode);
//        }
//    }


    public static class DisjointSets {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> rankMap;

        public DisjointSets() {
            fatherMap = new HashMap<Node, Node>();
            rankMap = new HashMap<Node, Integer>();
        }

        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        /**
         * 如果找不到父节点==其本身的节点，递归进行查找,并将路径上的节点进行打平处理
         *
         * @param n
         * @return
         */
        public Node findFather(Node n) {
            Node parentNode = fatherMap.get(n);
            if (parentNode != n) {
                parentNode = findFather(parentNode);
            }
            fatherMap.put(n, parentNode);
            return parentNode;
        }

        public void union(Node a, Node b) {

            Node aParentNode = this.findFather(a);
            Node bParentNode = this.findFather(b);

            if (aParentNode != bParentNode) {
                if (rankMap.get(aParentNode) > rankMap.get(bParentNode)) {
                    fatherMap.put(bParentNode, aParentNode);
                    rankMap.put(aParentNode, rankMap.get(aParentNode) + rankMap.get(bParentNode));

                } else {
                    fatherMap.put(aParentNode, bParentNode);
                    rankMap.put(bParentNode, rankMap.get(aParentNode) + rankMap.get(bParentNode));

                }
            }

        }

        public boolean checkIsSame(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return Boolean.FALSE;
            }
            return this.findFather(node1) == this.findFather(node2);
        }
    }


}