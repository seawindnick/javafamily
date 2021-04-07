package com.java.study.algorithm.zuo.abasic.basic_class_05;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/29/21 18:05
 */
public class Code_01_TrieTree2 {

    public static class TrieNode {
        public TrieNode[] next;

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
            TrieNode node = trieNode;
            for (int i = 0; i < arr.length; i++) {
                TrieNode[] next = node.next;
                int index = arr[i] - 'a';

                TrieNode indexNode = next[index];
                if (indexNode == null) {
                    indexNode = new TrieNode();
                    next[index] = indexNode;
                }

                indexNode.pathCount++;
                node = indexNode;

            }
            node.endCount++;
        }

        public Boolean search(String word) {
            if (word == null || word.length() == 0) {
                return Boolean.FALSE;
            }

            char[] arr = word.toCharArray();
            TrieNode node = trieNode;
            for (int i = 0; i < arr.length; i++) {
                TrieNode[] next = node.next;
                int index = arr[i] - 'a';

                TrieNode indexNode = next[index];
                if (indexNode == null) {
                    return Boolean.FALSE;
                }
                node = indexNode;
            }
            return node.endCount > 0;
        }

        public void delete(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            if (!search(word)) {
                return;
            }

            char[] arr = word.toCharArray();
            TrieNode node = trieNode;
            for (int i = 0; i < arr.length; i++) {
                TrieNode[] next = node.next;
                int index = arr[i] - 'a';

                TrieNode indexNode = next[index];
                indexNode.pathCount--;
                node = indexNode;
            }
            node.endCount--;
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
