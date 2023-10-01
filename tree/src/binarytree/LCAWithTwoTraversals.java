package binarytree;

import binarysearchtree.BinarySearchTreeImpl;
import main.PathToANode;
import main.TreeNode;

import java.util.ArrayList;

public class LCAWithTwoTraversals {

    public int findLCA(TreeNode node, int target1, int target2) {

        PathToANode pathToANode = new PathToANode();
        ArrayList<Integer> list1 = pathToANode.recursiveTraversal(node, target1);
        System.out.println(list1);
        ArrayList<Integer> list2 = pathToANode.recursiveTraversal(node, target2);
        System.out.println(list2);

        for (int i = 0; i < list1.size() - 1 && i < list2.size() - 1; i++) {
            if (list1.get(i + 1) != list2.get(i + 1)) {
                return list1.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        TreeNode node = tree.insertIntoBinarySearchTree(40, 20, 60, 10, 30, 50, 70);
        LCAWithTwoTraversals lca = new LCAWithTwoTraversals();
        System.out.println(lca.findLCA(node, 10, 70));

    }

}
