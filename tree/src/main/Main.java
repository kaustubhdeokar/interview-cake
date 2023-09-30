package main;

import binarysearchtree.BinarySearchTreeImpl;
import binarytree.BinaryTreeImpl;

public class Main {
    public static void main(String[] args) {

      //  binaryTree();
        binarySearchTree();

    }

    private static void binarySearchTree() {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        TreeNode node = tree.insertIntoBinarySearchTree(40,20,60,10,30,50,70);
        Traversal traversal = new Traversal(true);
        traversal.traversePreOrder(node);
    }

    private static void binaryTree() {
        BinaryTreeImpl tree = new BinaryTreeImpl();
        TreeNode node = (TreeNode) tree.createTreeAccordingToUserInput();
        Traversal traversal = new Traversal(true);
        traversal.traversePreOrder(node);
    }
}