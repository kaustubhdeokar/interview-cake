package binarytree;

import main.Traversal;
import main.TreeNode;

import java.util.ArrayDeque;

public class ArrayToTree {

    public static void main(String[] args) {

        Integer[] arr = {3, 1, 4, 3, null, 1, 5};
        ArrayToTree arrayToTree = new ArrayToTree();
        TreeNode tree = arrayToTree.createTree(arr);
        Traversal traversal = new Traversal(true);
        traversal.levelOrder(tree);
    }

    public TreeNode createTree(Integer[] arr) {
        if (arr.length == 0) return null;
        TreeNode head = new TreeNode(arr[0]);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int i = 1;

        while (!queue.isEmpty()) {

            TreeNode curr = queue.remove();

            if (i < arr.length) {

                TreeNode left;
                if (arr[i] == null) {
                    left = null;
                } else {
                    left = new TreeNode(arr[i]);
                }

                curr.left = left;
                if (left != null) {
                    queue.add(left);
                }
                i += 1;
            } else {
                curr.left = null;
            }

            if (i < arr.length) {
                TreeNode right;
                if (arr[i] == null) {
                    right = null;
                } else {
                    right = new TreeNode(arr[i]);
                }

                curr.right = right;
                if (right != null) {
                    queue.add(right);
                }
                i += 1;
            } else {
                curr.right = null;
            }
        }

        return head;
    }

}
