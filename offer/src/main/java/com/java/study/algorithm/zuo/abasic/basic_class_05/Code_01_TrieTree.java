package com.java.study.algorithm.zuo.abasic.basic_class_05;

/**
 * 前缀树
 * arr2中有哪些字符，是arr1中出现的?请打印
 */
public class Code_01_TrieTree {


    public static class TrieNode {
        public TrieNode[] next;
        //是有单词以此结尾
        public boolean end = Boolean.FALSE;
        //以此为结尾的元素数量
        int pathCount = 0;

        int endCount = 0;

        public TrieNode() {
            next = new TrieNode[52];
        }
    }



    public static class TrieTree {

        private TrieNode trieNode;

        public TrieTree() {
            trieNode = new TrieNode();
        }


        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] arr = word.toCharArray();

            TrieNode[] next = trieNode.next;
            for (int i = 0; i < arr.length; i++) {
                char indexChar = arr[i];

                int index = indexChar - 'a';
                TrieNode tempNext = next[index];
                if (tempNext == null) {
                    tempNext = new TrieNode();
                    next[index] = tempNext;
                }

                if (i == arr.length - 1) {
                    tempNext.end = true;
                    tempNext.endCount++;
                }
                tempNext.pathCount++;
                next = tempNext.next;
            }
        }

        public Boolean search(String word) {
            if (word == null || word.length() == 0) {
                return Boolean.FALSE;
            }
            char[] arr = word.toCharArray();
            TrieNode[] next = trieNode.next;

            for (int i = 0; i < arr.length; i++) {
                char indexChar = arr[i];

                int index = indexChar - 'a';
                if (next[index] == null || next[index].pathCount == 0) {
                    return Boolean.FALSE;
                }

                if (i == arr.length - 1 && !next[index].end) {
                    return Boolean.FALSE;
                }

                next = next[index].next;
            }
            return Boolean.TRUE;
        }

        public void delete(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            if (!search(word)) {
                return;
            }

            char[] arr = word.toCharArray();
            TrieNode[] next = trieNode.next;

            for (int i = 0; i < arr.length; i++) {
                char indexChar = arr[i];
                int index = indexChar - 'a';
                TrieNode trieNode = next[index];

                TrieNode[] tempNext = trieNode.next;

                --trieNode.pathCount;
                --trieNode.endCount;
                if (trieNode.pathCount == 0) {
                    next[index] = null;
                }
                if (i == arr.length - 1 && trieNode.endCount == 0) {
                    trieNode.end = Boolean.FALSE;
                }

                next = tempNext;

            }

        }


    }


    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.search("zuoad"));
//        System.out.println(trie.prefixNumber("zuo"));

    }


}