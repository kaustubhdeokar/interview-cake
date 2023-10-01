package main;

import binarysearchtree.BinarySearchTreeImpl;

import java.util.ArrayList;

public class PathToANode {

    public ArrayList<Integer> recursiveTraversal(TreeNode node, int target) {

        ArrayList<Integer> path = new ArrayList<>();
        boolean[] targetFound = {false};
        recursiveTraversal(node, target, path, targetFound);
        return path;
    }

    public void recursiveTraversal(TreeNode node, int target, ArrayList<Integer> path, boolean[] targetFound) {

        if (node == null || targetFound[0]) return;

        path.add(node.val);

        recursiveTraversal(node.left, target, path, targetFound);

        if (node.val == target) {
            targetFound[0] = true;
            return;
        }

        recursiveTraversal(node.right, target, path, targetFound);

        if (!targetFound[0]) {
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        TreeNode node = tree.insertIntoBinarySearchTree(40, 20, 60, 10, 30, 50, 70);
        PathToANode traversal = new PathToANode();
        ArrayList<Integer> list1 = traversal.recursiveTraversal(node, 50);
        ArrayList<Integer> list2 = traversal.recursiveTraversal(node, 70);

        System.out.println(list1);
        System.out.println(list2);
    }

}
