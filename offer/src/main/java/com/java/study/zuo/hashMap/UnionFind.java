package com.java.study.zuo.hashMap;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <Description>
 * 并查集
 *
 * @author hushiye
 * @since 2020-08-03 17:58
 */
public class UnionFind<T> {
    private Map<Node, Node> fatherNMap;
    private Map<Node, Integer> sizeMap;


    public UnionFind(List<Node> list) {
        fatherNMap.clear();
        sizeMap.clear();

        //设置自己是自己的父节点,长度为1
        list.forEach(node -> {
            fatherNMap.put(node, node);
            sizeMap.put(node, 1);
        });
    }

    /**
     * 查询最上的父节点，并将沿途的路径扁平化
     * @param node
     * @return
     */
    public Node findHead(Node node) {
        Node fatherNode = fatherNMap.get(node);
        if (fatherNode != node) {
            fatherNode = findHead(fatherNode);
        }

        //将树结构扁平化
        fatherNMap.put(node, fatherNode);
        return fatherNode;
    }

    /**
     * 判断两个节点是否在同一个集合中，只需要判断最终的父节点是否一样
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSamall(Node a, Node b) {
        if (a == null || b == null){
            return Boolean.FALSE;
        }
        return findHead(a) == findHead(b);
    }

    /**
     * 1。判断两个节点最后的父节点是否一致
     * 2。如果a父节点挂载元素数量 > b父节点挂载元素数量，将 b父节点挂载到a上
     * 3。如果a父节点挂载元素数量 <= b父节点挂载元素数量，将 a父节点挂载到b上
     * @param a
     * @param b
     */
    public void union(Node a, Node b) {
        if (a == null || b == null){
            return;
        }

        Node aParent = findHead(a);
        Node bParent = findHead(b);
        if (aParent != bParent) {
            // 将 b树挂在到 a 上
            if (sizeMap.get(aParent) > sizeMap.get(bParent)) {
                fatherNMap.put(bParent, aParent);
                sizeMap.put(aParent, sizeMap.get(aParent) + sizeMap.get(bParent));
            } else {
                fatherNMap.put(aParent, bParent);
                sizeMap.put(bParent, sizeMap.get(aParent) + sizeMap.get(bParent));
            }
        }

    }

    @Data
    public static class Node<T> {
        private int value;
        private Node node;
    }

}
