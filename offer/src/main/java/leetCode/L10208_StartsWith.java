package leetCode;//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
// 用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。
//
// 请你实现 Trie 类：
//
//
// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。
//
//
//
//
// 示例：
//
//
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
//
//
//
//
// 提示：
//
//
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
//
// Related Topics 设计 字典树 哈希表 字符串
// 👍 840 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Inserts a word into the trie.
 */
public class L10208_StartsWith {

    private TrieNode root;

    public L10208_StartsWith() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode insetTreeNode = root;
        for (int index = 0; index < word.toCharArray().length; index++) {
            char indexChar = word.charAt(index);
            int charIndex = indexChar - 'a';

            TrieNode[] insetTreeNodeArray = insetTreeNode.trieNodes;
            TrieNode indexTreeNode = insetTreeNodeArray[charIndex];
            if (indexTreeNode == null) {
                indexTreeNode = new TrieNode();
                insetTreeNodeArray[charIndex] = indexTreeNode;
            }
            if (index == word.length() - 1) {
                indexTreeNode.endFlag = true;
            }
            insetTreeNode = indexTreeNode;
        }


    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        TrieNode startNode = root;
        for (int checkIndex = 0; checkIndex < word.length(); checkIndex++) {
            char indexChar = word.charAt(checkIndex);
            int charIndex = indexChar - 'a';

            TrieNode[] existTireNodeArray = startNode.trieNodes;
            TrieNode charIndexNode = existTireNodeArray[charIndex];
            if (charIndexNode == null) {
                return false;
            }

            if (checkIndex == word.length() - 1) {
                return charIndexNode.endFlag;
            }
            startNode = charIndexNode;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        TrieNode startNode = root;
        for (int checkIndex = 0; checkIndex < prefix.length(); checkIndex++) {
            char indexChar = prefix.charAt(checkIndex);
            int charIndex = indexChar - 'a';

            TrieNode[] existTireNodeArray = startNode.trieNodes;
            TrieNode charIndexNode = existTireNodeArray[charIndex];
            if (charIndexNode == null) {
                return false;
            }
            startNode = charIndexNode;
        }
        return true;
    }


    public static class TrieNode {
        private TrieNode[] trieNodes = new TrieNode[26];
        private Boolean endFlag = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

