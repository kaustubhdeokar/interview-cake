package main;

import binarysearchtree.BinarySearchTreeImpl;

import java.util.Stack;

public class InorderIterative {

    public void inorderTraversal(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            while (!stack.isEmpty() && stack.peek().right == null) {
                System.out.println(stack.pop().val);
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current.val);
            }
            if (current != null) {
                current = current.right;
            }
        }

    }

    public static void main(String[] args) {

        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        TreeNode node = binarySearchTree.insertIntoBinarySearchTree(5, 3, 7, 6, 8, 1, 10);
        InorderIterative inorderIterative = new InorderIterative();
        inorderIterative.inorderTraversal(node);
    }

}
