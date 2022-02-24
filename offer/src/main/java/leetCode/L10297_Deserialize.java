package leetCode;//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 104] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 设计
// 👍 552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Encodes a tree to a single string.
public class L10297_Deserialize {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);


        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;

        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;

        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        System.out.println(serialize(treeNode3));


    }



    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }

        String str = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                str = str + "#_";
            } else {
                str = str + treeNode.val + "_";
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }

        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrArray = data.split("_");
        LinkedList<String> nodeValueList = new LinkedList<>();
        for (String nodeValue : nodeStrArray) {
            nodeValueList.add(nodeValue);
        }

        TreeNode root = buildNode(nodeValueList.removeFirst());
        LinkedList<TreeNode> levelNodeList = new LinkedList<>();
        levelNodeList.add(root);
        while (!nodeValueList.isEmpty()) {
            TreeNode parentNode = levelNodeList.pop();
            TreeNode leftNode = buildNode(nodeValueList.pop());
            TreeNode rightNode = buildNode(nodeValueList.pop());
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            if (leftNode != null) {
                levelNodeList.add(leftNode);
            }
            if (rightNode != null) {
                levelNodeList.add(rightNode);
            }
        }

        return root;
    }

    private TreeNode buildNode(String nodeValue) {
        if (nodeValue.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(nodeValue);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


