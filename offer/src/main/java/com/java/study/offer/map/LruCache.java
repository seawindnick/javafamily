package com.java.study.offer.map;

import lombok.Data;

import java.util.HashMap;

public class LruCache {


    private Node head;

    private Node end;
    private Integer limit;

    private HashMap<String,Node> hashMap;

    public LruCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<>();
    }


    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }

        refreshNode(node);
        return node.value;
    }

    public void put(String key,String value){
        Node node = hashMap.get(key);
        if (node == null){
            //超过限定额度，移除头元素
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node();
            node.setKey(key);
            node.setValue(value);
            addNode(node);
        }else {
            node.value = value;
            refreshNode(node);
        }

    }

    private void addNode(Node node) {
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    private void refreshNode(Node node) {
        if (node == end){
            return;
        }
        //删除元素
        removeNode(node);
        //添加元素
        addNode(node);
    }

    private String removeNode(Node node) {
        if(node == head && node == end){
            head = null;
            end = null;
        }else if (node == null){
            end = end.pre;
            end.next = null;
        }else if (node == head){
            head = head.next;
            head.pre = null;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;

    }


    @Data
    public static class Node{
        private Node pre;
        private Node next;
        private String key;
        private String value;
    }
}
