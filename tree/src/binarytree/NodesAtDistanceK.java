package binarytree;

import main.TreeNode;

import java.util.ArrayList;

public class NodesAtDistanceK {

    public static void main(String[] args) {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        TreeNode root = binaryTree.createTreeAccordingToUserInput();
        NodesAtDistanceK distK = new NodesAtDistanceK();
        distK.getNodesAtDist(root, root, 2);
    }

    private void getNodesAtDist(TreeNode head, TreeNode target, int dist) {

        ArrayList<TreeNode> list = new ArrayList<>();
        traverseFromTarget(target, dist, list);


        for (TreeNode l : list) {
            System.out.print(l.val + " ");
        }

        int distanceFromRoot = calculateDistanceFromRoot(head, target);
        System.out.println("Distance from root:" + distanceFromRoot);
    }

    private int calculateDistanceFromRoot(TreeNode head, TreeNode target) {
        return calculateDistanceFromRoot(head, target, 0);
    }

    private int calculateDistanceFromRoot(TreeNode head, TreeNode target, int currLevel) {

        if (head == null) return Integer.MIN_VALUE;
        if (head == target) return currLevel;

        return Integer.max(calculateDistanceFromRoot(head.left, target, currLevel + 1),
                calculateDistanceFromRoot(head.right, target, currLevel + 1));

    }

    private void traverseFromTarget(TreeNode target, int dist, ArrayList<TreeNode> list) {

        if (target == null) {
            return;
        }

        if (dist == 0) {
            list.add(target);
            return;
        }

        traverseFromTarget(target.left, dist - 1, list);
        traverseFromTarget(target.right, dist - 1, list);

    }


}
