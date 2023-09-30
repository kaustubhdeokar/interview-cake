package binarysearchtree;

import main.TreeNode;

public class BinarySearchTreeImpl {


    public TreeNode insertIntoBinarySearchTree(int... nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insertIntoBinarySearchTree(root, num);
        }
        return root;
    }

    public TreeNode insertIntoBinarySearchTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBinarySearchTree(root.left, val);
        } else {
            root.right = insertIntoBinarySearchTree(root.right, val);
        }
        return root;
    }


}
