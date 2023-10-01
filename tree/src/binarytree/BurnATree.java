package binarytree;

import binarysearchtree.BinarySearchTreeImpl;
import main.TreeNode;

import java.util.ArrayList;

public class BurnATree {

    public ArrayList<Integer> burnATree(TreeNode node, int leaf) {

        ArrayList<Integer> path = new ArrayList<>();
        boolean[] targetFound = {false};
        recursiveTraversal(node, leaf, path, targetFound);
        return path;
    }

    public int recursiveTraversal(TreeNode node, int target, ArrayList<Integer> path, boolean[] targetFound) {

        if (node == null || targetFound[0]) return -1;

        path.add(node.val);

        int left = recursiveTraversal(node.left, target, path, targetFound);

        if (node.val == target) {
            targetFound[0] = true;
            return 1;
        }

        int right = recursiveTraversal(node.right, target, path, targetFound);

        if (!targetFound[0]) {
            path.remove(path.size() - 1);
        } else {
            System.out.print("Node:" + node.val+" curr height:");
            if (left != -1) {
                System.out.println(left);
                System.out.println("find height of " + node.right.val);
                // left branch. - find out max height of right branch.
            }
            if (right != -1) {
                System.out.println(right);
                System.out.println("find height of " + node.left.val);
                // right branch. - find out max height of left branch.
            }
            System.out.println();
        }
        if (left != -1) return left + 1;
        else if (right != -1) return right + 1;
        else return -1;
    }

    public static void main(String[] args) {

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        TreeNode node = tree.insertIntoBinarySearchTree(40, 20, 60, 10, 30, 50, 70);
        BurnATree burnATree = new BurnATree();
        burnATree.burnATree(node, 50);
    }

}
