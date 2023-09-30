package binarytree;

import binarysearchtree.BinarySearchTreeImpl;
import main.TreeNode;

// idea here is to do a inorder traversal maintaining a previous pointer such that we are able to
// establish left and right links between them.

public class BinaryTreeToDoublyLinkedList {

    public TreeNode binaryTreeToDoublyLinkedList(TreeNode node) {
        TreeNode[] prev = {null};
        TreeNode head = inorderWithPrev(node, prev);
        return head;

    }


    public TreeNode inorderWithPrev(TreeNode node, TreeNode[] prev) {
        if (node == null) {
            return node;
        }

        TreeNode head = inorderWithPrev(node.left, prev);

        if (prev[0] == null) {
            head = node;
        } else {
            node.left = prev[0];
            prev[0].right = node;
        }
        prev[0] = node;

        inorderWithPrev(node.right, prev);

        return head;
    }

    public static void main(String[] args) {

        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        TreeNode node = binarySearchTree.insertIntoBinarySearchTree(5, 3, 7, 6, 8, 1, 10);
        BinaryTreeToDoublyLinkedList blToDll = new BinaryTreeToDoublyLinkedList();
        blToDll.binaryTreeToDoublyLinkedList(node);
    }

}
