package binarysearchtree;

import main.TreeNode;

public class BalancedTree {

    public static void main(String[] args) {

        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        TreeNode node = binarySearchTree.insertIntoBinarySearchTree(5, 3, 7, 6, 8);
        BalancedTree balancedTree = new BalancedTree();
        System.out.println(balancedTree.isBalancedTree(node));

        node = binarySearchTree.insertIntoBinarySearchTree(5, 3, 7, 6, 8,9);
         System.out.println(balancedTree.isBalancedTree(node));

    }

    public boolean isBalancedTree(TreeNode node) {

        boolean[] isBalanced = {true};
        isBalanced(node, isBalanced);
        return isBalanced[0];
    }

    public int isBalanced(TreeNode node, boolean[] isBalanced) {

        if (!isBalanced[0] || node == null) return 0;

        int left = isBalanced(node.left, isBalanced);
        int right = isBalanced(node.right, isBalanced);

        isBalanced[0] = isBalanced[0] && (Math.abs(left - right) <= 1);

        return 1 + Math.max(left, right);
    }


}
