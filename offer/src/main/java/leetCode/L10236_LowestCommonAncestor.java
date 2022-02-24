package leetCode;//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
//
//
// 示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//
// 示例 2：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//
// 示例 3：
//
//
//输入：root = [1,2], p = 1, q = 2
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 105] 内。
// -109 <= Node.val <= 109
// 所有 Node.val 互不相同 。
// p != q
// p 和 q 均存在于给定的二叉树中。
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 1239 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.java.study.zuo.linkedList.Node;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Definition for a binary tree node.
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class L10236_LowestCommonAncestor {

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

        System.out.println(lowestCommonAncestor(treeNode3, treeNode5, treeNode4).val);


    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode[][] existParentNodes = new TreeNode[2][];

        List<TreeNode> searchTreeNode = new ArrayList<>();
        fullExistParentNodes(root, p, q, existParentNodes, searchTreeNode);

        TreeNode[] pNodeParentNodeArray = existParentNodes[0];
        TreeNode[] qNodeParentNodeArray = existParentNodes[1];


        //寻找两个集合中第一个相同的元素
        Set<TreeNode> pNodeParentSet = new HashSet<>();
        for (int index = 0; index < pNodeParentNodeArray.length; index++) {
            pNodeParentSet.add(pNodeParentNodeArray[index]);
        }


        for (int index = qNodeParentNodeArray.length - 1; index >= 0; index--) {
            if (pNodeParentSet.contains(qNodeParentNodeArray[index])) {
                return qNodeParentNodeArray[index];
            }
        }

        return null;
    }

    private static void fullExistParentNodes(TreeNode node, TreeNode p, TreeNode q, TreeNode[][] existParentNodes, List<TreeNode> searchTreeNode) {
        if (node == null){
            return;
        }
        searchTreeNode.add(node);
        if (node == q) {
            TreeNode[] qNodeParentArray = searchTreeNode.toArray(new TreeNode[searchTreeNode.size()]);
            existParentNodes[0] = qNodeParentArray;
        }

        if (node == p) {
            TreeNode[] pNodeParentArray = searchTreeNode.toArray(new TreeNode[searchTreeNode.size()]);
            existParentNodes[1] = pNodeParentArray;
        }

        if (existParentNodes[0] != null && existParentNodes[1] != null){
            return;
        }

        fullExistParentNodes(node.left, p, q, existParentNodes, searchTreeNode);
        fullExistParentNodes(node.right, p, q, existParentNodes, searchTreeNode);
        searchTreeNode.remove(searchTreeNode.size()-1);
    }

    private static void fullParentNodeMap(Map<TreeNode, List<TreeNode>> parentNodeMap, TreeNode node, List<TreeNode> searchTreeNodeCollect) {
        if (node == null) {
            return;
        }

        searchTreeNodeCollect.add(node);
        List<TreeNode> list = new ArrayList<>(searchTreeNodeCollect);
        parentNodeMap.put(node, list);

        fullParentNodeMap(parentNodeMap, node.left, searchTreeNodeCollect);
        fullParentNodeMap(parentNodeMap, node.right, searchTreeNodeCollect);
        searchTreeNodeCollect.remove(searchTreeNodeCollect.size() - 1);
    }
//
//    public static class ParentNode{
//        private List<>
//    }

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


