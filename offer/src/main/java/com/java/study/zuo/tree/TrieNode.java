package com.java.study.zuo.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * <Description>
 * 字典树
 *
 * @author hushiye
 * @since 2020-08-03 22:05
 */
public class TrieNode {

    private Node headNode;

    public TrieNode() {
        this.headNode = new Node();
    }

    public void add(String str) {
        char[] charArray = str.toCharArray();
        Node[] nodes = headNode.nodes;
        for (int i = 0; i < charArray.length; i++) {
            char indexChar = charArray[i];
            Integer index = indexChar - 'a';
            if (nodes[index] == null) {
                nodes[index] = new Node(indexChar);
            }

            nodes[index].path++;
            if (i == charArray.length - 1) {
                nodes[index].end++;
            }

            nodes = nodes[index].nodes;
        }
    }


    public void delete(String str) {

        boolean checkExist = this.checkExist(str);
        if (checkExist) {

            char[] charArray = str.toCharArray();
            Node[] nodes = headNode.nodes;

            for (int i = 0; i < charArray.length; i++) {
                Integer index = charArray[i] - 'a';

                if (nodes[index].path == 1) {
                    nodes[index] = null;
                    return;
                }
                nodes[index].path--;

                if (i == charArray.length - 1) {
                    nodes[index].end--;
                }
            }
        }


    }

    private boolean checkExist(String str) {
        char[] charArray = str.toCharArray();
        Node[] nodes = headNode.nodes;

        for (int i = 0; i < charArray.length; i++) {
            Integer index = charArray[i] - 'a';
            if (nodes[index] == null) {
                return Boolean.FALSE;
            }
            nodes = nodes[index].nodes;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();
        trieNode.add("asdqwe");
        trieNode.add("asbvcc");
        System.out.println(JSONObject.toJSONString(trieNode.headNode));
    }


    @Data
    public static class Node {
        private char indexChar;
        private int path;
        private int end;

        private Node[] nodes = new Node[26];

        public Node() {
        }

        public Node(char indexChar) {
            this.indexChar = indexChar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }

            Node node = (Node) o;
            return getIndexChar() == node.getIndexChar();
        }

        @Override
        public int hashCode() {
            return (int) getIndexChar();
        }
    }


}
