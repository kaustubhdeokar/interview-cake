package binarytree;

import binarysearchtree.BinarySearchTreeImpl;
import main.TreeNode;

public class LCAOptimised {

    public TreeNode lcaOptimised(TreeNode node, int target1, int target2) {

        if (node == null) return null;
        if (node.val == target1 || node.val == target2) return node;

        TreeNode left = lcaOptimised(node.left, target1, target2);
        TreeNode right = lcaOptimised(node.right, target1, target2);

        if (left != null && right != null) {
            return node; //lca.
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null; // not found in any child.
        }


    }

    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        TreeNode node = tree.insertIntoBinarySearchTree(40, 20, 60, 10, 30, 50, 70);
        LCAOptimised lca = new LCAOptimised();
        System.out.println(lca.lcaOptimised(node, 70, 50).val);
    }

}
