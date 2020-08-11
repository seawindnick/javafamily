package com.java.study.zuo.tree;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-03 23:11
 */
public class TrieNode2 {
    public static class Trie {
        private TrieTreeNode root;

        public Trie() {
            root = new TrieTreeNode();
        }


        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] array = word.toCharArray();

            //上一个元素
            TrieTreeNode node = root;
            for (int i = 0; i < array.length; i++) {
                Integer index = array[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieTreeNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            //最后一个元素结尾数量++
            node.end++;
        }

        public void delete(String word) {
            if (word == null) {
                return;
            }

            if (search(word) != 0) {
                char[] charArray = word.toCharArray();

                TrieTreeNode trieTreeNode = root;
                for (int i = 0; i < charArray.length; i++) {
                    Integer index = charArray[i] - 'a';
                    // 元素路径--之后，若为0，则将其后整个链都删掉
                    if (--trieTreeNode.nexts[index].path == 0) {
                        trieTreeNode.nexts[index] = null;
                        break;
                    }
                    trieTreeNode = trieTreeNode.nexts[index];
                }
                trieTreeNode.end--;
            }

        }


        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] array = pre.toCharArray();
            TrieTreeNode trieTreeNode = root;
            for (int i = 0; i < array.length; i++) {
                Integer index = array[i] - 'a';
                if (trieTreeNode.nexts[index] == null) {
                    return 0;
                }
                trieTreeNode = trieTreeNode.nexts[index];
            }
            return trieTreeNode.path;
        }


        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] charArray = word.toCharArray();
            TrieTreeNode trieTreeNode = root;
            for (int i = 0; i < charArray.length; i++) {
                Integer index = charArray[i] - 'a';
                if (trieTreeNode.nexts[index] == null) {
                    return 0;
                }
                trieTreeNode = trieTreeNode.nexts[index];
            }
            return trieTreeNode.end;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
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
        System.out.println(trie.prefixNumber("zuo"));

    }

    public static class TrieTreeNode {
        //经过该节点的字符串数量
        public int path;
        //以该字符结尾的字符串数量
        public int end;
        public TrieTreeNode[] nexts;

        public TrieTreeNode() {
            path = 0;
            end = 0;
            nexts = new TrieTreeNode[26];
        }
    }


}
